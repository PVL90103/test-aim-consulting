package reader;

import java.io.*;
import java.util.*;


/**
 * Class CSVReader implements interface Reader
 */
public class CSVReader implements Reader {

    private final static String DELIMITER = ";";
    private final String inputFile;


    public CSVReader(String inputFile) {
        this.inputFile = inputFile;
    }

    /**
     * This method read lines without header. Synchronized guarantees that no other thread can interrupt the execution of the method.
     * @return All lines from .csv file as list of lists
     */
    @Override
    public synchronized List<List<String>> readLines() {
        List<List<String>> records = new ArrayList<>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){

            //first line is header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                records.add(Arrays.asList(values));
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * This method reads the header. Synchronized guarantees that no other thread can interrupt the execution of the method.
     * @return All fields from header(first line in .csv file) as list
     */
    @Override
    public synchronized List<String> readHeader() {
        List<String> valuesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String[] line = br.readLine().split(DELIMITER);

            valuesList.addAll(Arrays.asList(line));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return valuesList;
    }

}
