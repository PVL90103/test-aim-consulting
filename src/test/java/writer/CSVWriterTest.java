package writer;

import org.junit.Test;
import reader.CSVReader;

import java.util.List;

import static org.junit.Assert.*;

public class CSVWriterTest {

    @Test
    public void writeTest() {
        CSVReader csvReader = new CSVReader("src/main/resources/input2.csv");
        List<List<String>> values = csvReader.readLines();
        List<String> header = csvReader.readHeader();

        CSVWriter csvWriter = new CSVWriter();
        csvWriter.write(header, values);

    }
}