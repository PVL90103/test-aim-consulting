package writer;

import struct.Struct;

import java.io.*;
import java.util.List;

import static parser.CSVParser.*;

/**
 * Class CSVWriter implements interface Writer
 */
public class CSVWriter implements Writer {

    private final List<String> header;
    private final List<List<String>> values;

    /**
     * Constructor has two parameters
     * @param header is header
     * @param values is all elements
     */
    public CSVWriter(List<String> header, List<List<String>> values) {
        this.header = header;
        this.values = values;
    }

    /**
     * This method writes the elements from each column in the file named by its field from the header.
     * The files contain at the directory "src/main/resources/output/"
     * Synchronized guarantees that no other thread can interrupt the execution of the method.
     */
    @Override
    public synchronized void write() {

        File directory = new File("src/main/resources/output/");
        if (!directory.isDirectory()) directory.mkdir();
//
//        for(int i = 0; i < header.size(); i++) {
//            StringBuilder outputFile = new StringBuilder();
//            outputFile.append("src/main/resources/output/");
//            outputFile.append(getFieldFromHeaderAsString(header, i));
//            outputFile.append(".txt");
//
//            File file = new File(String.valueOf(outputFile));
//            try {
//                boolean isFileCreated = file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
//                bw.write(getElements(values, i));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
