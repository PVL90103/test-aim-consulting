package reader;

import java.util.List;
import java.util.Map;

public interface Reader {

    List<List<String>> readLines();

    List<String> readHeader();
}
