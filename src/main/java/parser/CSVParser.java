package parser;

import java.util.*;

public class CSVParser {

    public static String getField(Map<String, Integer> header) {
        Set<String> fields = header.keySet();
        return null;
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
