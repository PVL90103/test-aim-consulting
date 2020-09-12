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
     * This method writes the unique elements from each column in the file named by its field from the header.
     * The files contain at the directory "src/main/resources/output/"
     */
    @Override
    public void write() {

        //Creates the directory if it don't exist
        File directory = new File("src/main/resources/output/");
        if (!directory.isDirectory()) directory.mkdir();

        //Each file get file name and values for writing from structure
        for (Struct file: fileStructure) {
            StringBuilder fileName = new StringBuilder();
            fileName.append("src/main/resources/output/");
            fileName.append(file.getFileName());
            fileName.append(".txt");

            File f = new File(String.valueOf(fileName));
            try {
                boolean isFileCreated = f.createNewFile();

                if (isFileCreated || f.exists()) {
                    //Creates string of values for writing
                    StringBuilder values = new StringBuilder();
                    for (String i : file.getValues()) {
                        values.append(i);
                        values.append(";");
                    }
                    //Writes the values
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                        bw.write(values.toString());
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
