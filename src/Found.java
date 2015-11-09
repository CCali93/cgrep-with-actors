import java.util.ArrayList;
import java.util.List;

/**
 * Created by curtis on 11/9/15.
 */
public class Found {
    private List<String> foundLines;

    public Found() {
        this.foundLines = new ArrayList<>();
    }

    public void addLine(String line) {
        this.foundLines.add(line);
    }
}
