package printer;

import executor.Executor;
import reader.CSVReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    }
}
