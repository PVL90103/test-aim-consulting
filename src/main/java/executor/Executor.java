package executor;

import reader.CSVReader;
import writer.CSVWriter;

import java.util.List;

public class Executor extends Thread {

    private final CSVReader csvReader;

    public Executor(CSVReader csvReader) {
        this.csvReader = csvReader;

    }

    @Override
    public void run() {
        List<List<String>> values = csvReader.readLines();
        List<String> header = csvReader.readHeader();

        CSVWriter csvWriter = new CSVWriter(header, values);
        csvWriter.write();
    }
}
