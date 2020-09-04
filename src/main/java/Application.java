import reader.CSVReader;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        CSVReader csvReader = new CSVReader("src/main/resources/input2.csv");

        //Map<String,Integer> header = csvReader.readHeader();

        //System.out.println(header.toString());

        List<List<String>> lines = csvReader.readLines();

        System.out.println(lines.toString());
    }
}
