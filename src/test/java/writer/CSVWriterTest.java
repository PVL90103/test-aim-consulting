package writer;

import org.junit.Test;
import reader.CSVReader;

import java.util.List;

public class CSVWriterTest {

    @Test
    public void writeTest() {
        CSVReader csvReader = new CSVReader("src/main/resources/input2.csv");
        List<List<String>> values = csvReader.readLines();
        List<String> header = csvReader.readHeader();

        //CSVWriter csvWriter = new CSVWriter(fileStructure);
        //csvWriter.write();

    }
}