package parser;

import org.junit.Test;
import reader.CSVReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static parser.CSVParser.getElements;
import static parser.CSVParser.getFieldFromHeaderAsString;

public class CSVParserTest {

    @Test
    public void getFieldFromHeaderAsStringTest() {
        List<String> header = Arrays.asList("id", "version", "path");
        CSVReader csvReader = new CSVReader("src/main/resources/input1.csv");

        String expected = "version";
        String actual = getFieldFromHeaderAsString(header, 1);

        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void getElementsTest() {
        CSVReader csvReader = new CSVReader("src/main/resources/input1.csv");
        List<List<String>> lines = csvReader.readLines();
        List<String> expected = Arrays.asList("/hello/уточка", "/hello/лошадка", "/hello/собачка");
        int position = 2;

        List<String> actual = getElements(lines, position);
        assertEquals(expected, actual);
    }
}