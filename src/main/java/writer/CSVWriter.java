package writer;

import struct.Struct;

import java.io.*;
import java.util.List;

/**
 * Class CSVWriter implements interface Writer
 */
public class CSVWriter implements Writer {

    private final List<Struct> fileStructure;
    ;

    /**
     * Constructor has one parameter
     * @param fileStructure
     */
    public CSVWriter(List<Struct> fileStructure) {
        this.fileStructure = fileStructure;
    }

    /**
     * This method writes the elements from each column in the file named by its field from the header.
     * The files contain at the directory "src/main/resources/output/"
     */
    @Override
    public void write() {

        File directory = new File("src/main/resources/output/");
        if (!directory.isDirectory()) directory.mkdir();

        for (Struct file: fileStructure) {
            StringBuilder fileName = new StringBuilder();
            fileName.append("src/main/resources/output/");
            fileName.append(file.getFileName());
            fileName.append(".txt");

            File f = new File(String.valueOf(fileName));
            try {
                boolean isFileCreated = f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                bw.write(file.getValues().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
