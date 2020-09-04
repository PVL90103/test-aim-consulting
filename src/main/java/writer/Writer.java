package writer;

import java.util.List;
import java.util.Map;

public interface Writer {
    void write(Map<String, Integer> header, List<List<String>> values);
}
