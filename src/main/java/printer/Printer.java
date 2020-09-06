package printer;

import executor.Executor;
import reader.CSVReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Printer {
    public static void print() {

        Scanner in = new Scanner(System.in);
        String answer = "";
        List<String> files = new ArrayList<>();

        while (!answer.equalsIgnoreCase("ok")) {
            System.out.println("Your selected files: " );
            files.forEach(System.out::println);
            System.out.println("========================================================");
            System.out.println("Write the full path of your file, or write ok to cancel");
            System.out.println("-->");
            answer = in.nextLine();

            File file = new File(answer);
            if (!answer.equalsIgnoreCase("ok")) {
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("File not found");
                }
                if (file.exists() && !file.isDirectory()) files.add(answer);
            }
            //clear the screen
            System.out.flush();
        }

        if (!files.isEmpty()) {
            for(String item : files) {
                CSVReader csvReader = new CSVReader(item);
                Executor executor = new Executor(csvReader);
                executor.start();
            }
        }
//        String fileName1 = "src/main/resources/input1.csv";
//        String fileName2 = "src/main/resources/input2.csv";
//        String fileName3 = "src/main/resources/biostats.csv";
//
//        CSVReader csvReader1 = new CSVReader(fileName1);
//        CSVReader csvReader2 = new CSVReader(fileName2);
//        CSVReader csvReader3 = new CSVReader(fileName3);
//
//
//        Executor executor1 = new Executor(csvReader1);
//        Executor executor2 = new Executor(csvReader2);
//        Executor executor3 = new Executor(csvReader3);
//
//        executor1.start();
//        executor2.start();
//        executor3.start();

    }
}
