package reader;

import java.util.List;
import java.util.Map;

/**
 * Interface Reader has two methods:
 * readLines() read all lines in file, except header
 * readHeader() read header (first line in file)
 */
public interface Reader {

    List<List<String>> readLines();

    List<String> readHeader();
}
