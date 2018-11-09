import java.util.ArrayList;
import java.util.List;

public class Adjacency {
    public String key;
    public List<Adjacent> adjacentList;

    public Adjacency(String key) {
        this.key = key;
        this.adjacentList = new ArrayList<>();
    }

    public void addAdjacent(String adjacentVertexKey, int weight) {
        Adjacent adjacent = new Adjacent(adjacentVertexKey, weight);
        this.adjacentList.add(adjacent);
    }

    public void addAdjacent(String adjacentVertexKey) {
        Adjacent adjacent = new Adjacent(adjacentVertexKey);
        this.adjacentList.add(adjacent);
    }
}
