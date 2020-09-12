package struct;

import java.util.List;
import java.util.Set;

/**
 * This class represents itself a data structure that ties each file with its values(files get from a header that get from input files)
 */
public class Struct implements Comparable<Struct>{

    private final String fileName;
    private Set<String> values;

    public Struct(String fileName, Set<String> values) {
        this.fileName = fileName;
        this.values = values;
    }

    /**
     * This method adds new unique values in already existed values
     * @param values
     */
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
