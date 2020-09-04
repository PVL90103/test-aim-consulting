package writer;

import java.util.List;
import java.util.Map;

public class CSVWriter implements Writer {

    private String outputFile;

    public CSVWriter(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public void write(Map<String, Integer> header, List<List<String>> values) {

    }
}
