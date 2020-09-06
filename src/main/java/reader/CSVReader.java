package reader;

import java.io.*;
import java.util.*;

public class CSVReader implements Reader {

    private final static String DELIMITER = ";";
    private final String inputFile;


    public CSVReader(String inputFile) {
        this.inputFile = inputFile;
    }


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
