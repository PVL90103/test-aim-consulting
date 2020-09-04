package writer;

import java.util.List;
import java.util.Map;

public interface Writer {
    void write(List<String> header, List<List<String>> values);
}
