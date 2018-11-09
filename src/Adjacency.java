import java.util.ArrayList;
import java.util.List;

public class Adjacency {
    public String key;
    public List<Edge> edgeList;

    public Adjacency(String key) {
        this.key = key;
        this.edgeList = new ArrayList<>();
    }
}
