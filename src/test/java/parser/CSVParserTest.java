package parser;

import org.junit.Test;
import reader.CSVReader;
import java.util.List;

import static org.junit.Assert.*;
import static parser.CSVParser.getElementsAsString;

public class CSVParserTest {

    @Test
    public void getField() {
    }

    @Test
    public void getElementsAsStringTest() {
        CSVReader csvReader = new CSVReader("src/main/resources/input1.csv");
        List<List<String>> lines = csvReader.readLines();
        String expected = "/hello/уточка;/hello/лошадка;/hello/собачка;";
        int position = 2;

        String actual = getElementsAsString(lines, position);
        assertEquals(expected, actual);
    }
}