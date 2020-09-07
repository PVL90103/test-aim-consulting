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
     * @return Unique elements from the column as String
     */
    public static String getElementsAsString(List<List<String>> values, int position) {

        StringBuilder uniqueElements = new StringBuilder();
        List<String> column = new ArrayList<>();
        for (List line: values) {
            for (int i = 0; i < line.size(); i++){
                if (i == position) {
                    if (!column.contains(line.get(i).toString())) {
                        uniqueElements.append(line.get(i));
                        uniqueElements.append(";");
                    }
                    column.add(line.get(i).toString());
                }
            }
        }

        return uniqueElements.toString();
    }
}
