package parser;

import java.util.*;

public class CSVParser {

    public static String getFieldFromHeaderAsString(List<String> header, int position) {
        String[] fields = header.toArray(new String[0]);
        //System.out.println(Arrays.toString(fields));
        return fields[position];
    }

    public static String getElementsAsString(List<List<String>> values, int position) {

        StringBuilder elements = new StringBuilder();
        for (List line: values) {
            for (int i = 0; i < line.size(); i++){
                if (i == position) {
                    elements.append(line.get(i));
                    elements.append(";");
                }
            }
        }

        return elements.toString();
    }
}
