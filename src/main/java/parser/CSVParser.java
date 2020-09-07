package parser;

import java.util.*;

/**
 * Class CSVParser provide methods that parse .csv files
 */
public class CSVParser {

    /**
     * @param header Header from file
     * @param position Number of the field from the header
     * @return Name of a field from the header at the position(position) as String
     */
    public static String getFieldFromHeaderAsString(List<String> header, int position) {
        String[] fields = header.toArray(new String[0]);
        return fields[position];
    }

    /**
     * @param values All elements from the file
     * @param position Number of the column
     * @return All elements from the column as String
     */
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
