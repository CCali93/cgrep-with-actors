import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by curtis on 11/9/15.
 */
public class Found {
    private String fileName;
    private List<String> foundLines;

    public Found(String fileName, List<String> foundLines) {
        this.fileName = fileName;
        this.foundLines = new ArrayList<String>(foundLines);
    }

    public Iterator<String> getIterator() {
        return this.foundLines.iterator();
    }

    public String getFileName() {
        return this.fileName;
    }
}
