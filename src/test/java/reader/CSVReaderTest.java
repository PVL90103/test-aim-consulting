package reader;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CSVReaderTest {

    @Test
    public void readLines() {
        List<String> rowValues = new ArrayList<>();
        rowValues.add("1");
        rowValues.add("жорж");
        rowValues.add("м");

        CSVReader csvReader = new CSVReader("src/main/resources/input2.csv");
        List<List<String>> lines = csvReader.readLines();

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