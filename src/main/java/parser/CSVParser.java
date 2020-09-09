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
     * @return Unique elements from the column as List
     */
    public static List<String> getElements(List<List<String>> values, int position) {

        List<String> uniqueElements = new ArrayList<>();
        for (List line: values) {
            for (int i = 0; i < line.size(); i++){
                if (i == position) {
                    if (!uniqueElements.contains(line.get(i).toString())) {
                        uniqueElements.add(line.get(i).toString());
                    }
                }
            }
        }

        return uniqueElements;
    }
}
