import java.util.List;

public class Edge {
    String key, adjacentKey;
    int weight;

    public Edge(String key, String adjacentKey, int weight) {
        this.key = key;
        this.adjacentKey = adjacentKey;
        this.weight = weight;
    }

    public Edge(String key, String adjacentKey) {
        this.key = key;
        this.adjacentKey = adjacentKey;
    }

    public static Vertex findAdjacent(String adjacentVertexKey, List<Vertex> allVertices) {
        for (Vertex allVertice : allVertices) {
            if (allVertice.key.equals(adjacentVertexKey)) {
                return allVertice;
            }
        }

        return null;
    }
}
