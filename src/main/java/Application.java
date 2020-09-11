import struct.Struct;

import java.util.*;
import java.util.stream.Stream;

import static parser.CSVParser.getFileStructure;

/**
 * The main class of application
 * @author Pshenichnov Pavel
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {
        //Printer.print();

        String file1 = "id";
        Set<String> va1 = new LinkedHashSet<>();
        va1.addAll(Arrays.asList("0","1","2"));

        String file2 = "name";
        Set<String> va2 = new LinkedHashSet<>();
        va2.addAll(Arrays.asList("вася","коля","дима"));

        String file21 = "name";
        Set<String> va21 = new LinkedHashSet<>();
        va2.addAll(Arrays.asList("вася","Коля","Петя"));

        String file3 = "sex";
        Set<String> va3 = new LinkedHashSet<>();
        va3.addAll(Arrays.asList("м","ж","м"));

        String file31 = "sex";
        Set<String> va31 = new LinkedHashSet<>();
        va3.addAll(Arrays.asList("M","F","M"));

        String file4 = "id";
        Set<String> va4 = new LinkedHashSet<>();
        va4.addAll(Arrays.asList("0","2","3","4", "1", "5"));

        Struct struct1 = new Struct(file1, va1);
        Struct struct2 = new Struct(file2, va2);
        Struct struct3 = new Struct(file3, va3);
        Struct struct4 = new Struct(file4, va4);
        Struct struct5 = new Struct(file31, va31);
        Struct struct6 = new Struct(file21, va21);

//        struct1.addValues(struct4.getValues());


        List<Struct> structList = new ArrayList<>();
        structList.add(struct1);
        structList.add(struct2);
        structList.add(struct3);
        structList.add(struct4);
        structList.add(struct5);
        structList.add(struct6);


        List<Struct> distinctList = getFileStructure(structList);


        for (Struct i: distinctList) {
            System.out.println(i.getFileName());
            System.out.println(i.getValues().toString());
        }
    }
}
