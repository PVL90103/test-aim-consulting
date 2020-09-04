package writer;

import java.io.*;
import java.util.List;
import java.util.Map;
import static parser.CSVParser.*;


public class CSVWriter implements Writer {

    @Override
    public void write(List<String> header, List<List<String>> values) {
        for(int i = 0; i < header.size(); i++) {
            StringBuilder outputFile = new StringBuilder();
            outputFile.append("src/main/resources/output/");
            outputFile.append(getFieldFromHeaderAsString(header, i));
            outputFile.append(".txt");

            File file = new File(String.valueOf(outputFile));
            try {
                boolean isFileCreated = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                bw.write(getElementsAsString(values, i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
