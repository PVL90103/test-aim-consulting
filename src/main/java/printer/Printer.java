package printer;

import executor.Executor;
import reader.CSVReader;

public class Printer {
    public static void print() {


        String fileName1 = "src/main/resources/input1.csv";
        String fileName2 = "src/main/resources/input2.csv";
        String fileName3 = "src/main/resources/biostats.csv";

        CSVReader csvReader1 = new CSVReader(fileName1);
        CSVReader csvReader2 = new CSVReader(fileName2);
        CSVReader csvReader3 = new CSVReader(fileName3);


        Executor executor1 = new Executor(csvReader1);
        Executor executor2 = new Executor(csvReader2);
        Executor executor3 = new Executor(csvReader3);

        executor1.start();
        executor2.start();
        executor3.start();

    }
}
