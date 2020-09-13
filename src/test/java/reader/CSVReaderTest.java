package reader;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CSVReaderTest {

    @Test
    public void readLines() {
        List<String> rowValues = Arrays.asList("1", "жорж", "м");

        Reader csvReader = new CSVReader("src/main/resources/input2.csv");
        List<List<String>> lines = csvReader.readLines();

        assertEquals(rowValues, lines.get(2));
    }

    @Test
    public void readHeader() {

        List<String> expectedHeader = Arrays.asList("id", "version", "path");

        Reader csvReader = new CSVReader("src/main/resources/input1.csv");
        List<String> actualHeader = csvReader.readHeader();

        assertEquals(expectedHeader, actualHeader);
    }
}