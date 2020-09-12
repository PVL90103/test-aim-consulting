package printer;

import executor.Executor;
import reader.CSVReader;
import struct.Struct;
import writer.CSVWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static parser.CSVParser.getDistinctFileStructure;

/**
 * Class Printer has one method print()
 */
public class Printer {

    /**
     * This method prints the dialog with user. User could type the paths of the files.
     * When user has selected files and type "ok" the Executor starts the threads for each file.
     */
    public static void print() {

        Scanner in = new Scanner(System.in);
        String answer = "";
        List<String> filesForReading = new ArrayList<>();

        while (!answer.equalsIgnoreCase("ok")) {
            System.out.println("Your selected files: " );
            filesForReading.forEach(System.out::println);
            System.out.println("========================================================");
            System.out.println("Write the full path of your file, or write ok to cancel");
            System.out.println("-->");
            answer = in.nextLine();

            File file = new File(answer);
            if (!answer.equalsIgnoreCase("ok")) {
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("File not found");
                }
                if (file.exists() && !file.isDirectory()) filesForReading.add(answer);
            }
            System.out.println("========================================================");
            //clear the screen
            System.out.flush();
        }
        //Starts handling files
        startHandling(filesForReading);
    }


    /**
     * This method handling the files
     * @param filesForReading
     */
    private static void startHandling(List<String> filesForReading) {
        //Create synchronized list
        List<Struct> fileStructure = Collections.synchronizedList(new ArrayList<>());


        if (!filesForReading.isEmpty()) {
            for(String item : filesForReading) {

                //Create csvreader fir file
                CSVReader csvReader = new CSVReader(item);

                //Create and start thread executor
                Executor executor = new Executor(csvReader, fileStructure);
                executor.start();

                //Waiting for thread finish
                try {
                    executor.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Create csvwriter and give it unique elements from all files
            CSVWriter csvWriter = new CSVWriter(getDistinctFileStructure(fileStructure));
            csvWriter.write();

            System.out.println("The results have been written at the directory: src/main/resources/output");
        }
    }
}
