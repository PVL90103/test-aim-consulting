package executor;

import reader.CSVReader;
import struct.Struct;

import java.util.List;

import static parser.CSVParser.getElements;
import static parser.CSVParser.getFieldFromHeaderAsString;

/**
 * Class Executor has constructor with CSVReader and file structure as a parameters.
 * Method run() reads header and values from the file and builds file structure.
 */
public class Executor extends Thread {

    private final CSVReader csvReader;
    private List<Struct> fileStructure;

    public Executor(CSVReader csvReader, List<Struct> fileStructure) {
        this.csvReader = csvReader;
        this.fileStructure = fileStructure;
    }

    @Override
    public void run() {
        List<List<String>> values = csvReader.readLines();
        List<String> header = csvReader.readHeader();

        for (int i = 0; i < header.size(); i++) {
            Struct struct = new Struct(getFieldFromHeaderAsString(header, i), getElements(values, i));
            fileStructure.add(struct);
        }
    }
}
