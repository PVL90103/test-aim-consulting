package reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CSVReader implements Reader {

    private final String inputFile;


    public CSVReader(String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public List<List<String>> readLines() {
        return null;
    }

    @Override
    public Map<String, Integer> readHeader() {
        return null;
    }

}
