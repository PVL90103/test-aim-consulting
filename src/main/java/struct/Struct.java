package struct;

import java.util.List;
import java.util.Set;

public class Struct implements Comparable<Struct>{

    private final String fileName;
    private Set<String> values;

    public Struct(String fileName, Set<String> values) {
        this.fileName = fileName;
        this.values = values;
    }

    public void addValues(Set<String> values) {
        this.values.addAll(values);
    }

    public Set<String> getValues() {
        return values;
    }


    public void setValues(Set<String> values) {
        this.values = values;
    }


    public String getFileName() {
        return fileName;
    }


    @Override
    public int compareTo(Struct struct) {
        return this.fileName.compareTo(struct.getFileName());
    }

    @Override
    public String toString() {
        return "Struct{" +
                "fileName='" + fileName + '\'' +
                ", values=" + values +
                '}';
    }
}
