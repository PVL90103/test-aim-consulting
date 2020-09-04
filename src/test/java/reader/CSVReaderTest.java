package reader;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CSVReaderTest {

    @Test
    public void readLines() {
        List<String> rowValues = Arrays.asList("1", "жорж", "м");

        CSVReader csvReader = new CSVReader("src/main/resources/input2.csv");
        List<List<String>> lines = csvReader.readLines();

        //System.out.println(lines.get(0).get(2));
        assertEquals(rowValues, lines.get(2));
    }

    @Test
    public void readHeader() {
        Map<String,Integer> expectedHeader = new HashMap<>();
        expectedHeader.put("id", 0);
        expectedHeader.put("version", 1);
        expectedHeader.put("path", 2);

        CSVReader csvReader = new CSVReader("src/main/resources/input1.csv");
        Map<String,Integer> actualHeader = csvReader.readHeader();

        assertEquals(expectedHeader, actualHeader);
    }
}