package writer;

import org.junit.Test;
import reader.CSVReader;
import reader.Reader;
import struct.Struct;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class CSVWriterTest {

    @Test
    public void writeTest() {
        String file1 = "id";
        Set<String> va1 = new LinkedHashSet<>();
        va1.addAll(Arrays.asList("0","1","2"));

        String file2 = "name";
        Set<String> va2 = new LinkedHashSet<>();
        va2.addAll(Arrays.asList("вася","коля","дима"));

        String file3 = "sex";
        Set<String> va3 = new LinkedHashSet<>();
        va3.addAll(Arrays.asList("м","ж","м"));

        Struct struct2 = new Struct(file2, va2);
        Struct struct3 = new Struct(file3, va3);
        Struct struct5 = new Struct(file1, va1);


        List<Struct> structList = new ArrayList<>();
        structList.add(struct2);
        structList.add(struct3);
        structList.add(struct5);


        Writer csvWriter = new CSVWriter(structList);
        csvWriter.write();

        String actual = "";
        File file = new File("src/main/resources/output/id.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            actual = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = "0;1;2;";

        assertEquals(expected, actual);
    }
}