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
    public List<List<String>> readLines() {
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
    public Map<String, Integer> readHeader() {
        Map<String, Integer> valuesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String[] line = br.readLine().split(DELIMITER);

            int i = 0;
            for (String temp: line){
                valuesMap.put(temp, i);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return valuesMap;
    }

}
