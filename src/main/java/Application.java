import handler.Handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class of application
 * @author Pshenichnov Pavel
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {
        /**
         * Print the dialog with user. User could type the paths of the files.
         * When user has selected files and type "ok" method returns the list of files for handling.
         */
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

        //handling selected files
        Handler.startHandling(filesForReading);
    }



}