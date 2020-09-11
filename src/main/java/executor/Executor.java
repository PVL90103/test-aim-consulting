package executor;

import reader.CSVReader;
import writer.CSVWriter;

import java.util.List;

/**
 * Class Executor has constructor with CSVReader as a parameter. Method run() create CSVWriter and call method write().
 */
public class Executor extends Thread {

    private final CSVReader csvReader;

    public Executor(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public void run() {
        List<List<String>> values = csvReader.readLines();
        List<String> header = csvReader.readHeader();



        //CSVWriter csvWriter = new CSVWriter(header, values);
        //csvWriter.write();
    }
}
