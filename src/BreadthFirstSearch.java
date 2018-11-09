import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    public Graph graph;
    public List<String> visitedVertices;
    public Queue bfsQueue;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.visitedVertices = new ArrayList<>();
        this.bfsQueue = new Queue();
    }

    private boolean wasntVisited(String key) {
        for (String visitedKey : visitedVertices) {
            if (visitedKey.equals(key)) {
                return false;
            }
        }

        return true;
    }

    public void go() {
        Vertex vertex;
        for (Adjacency adjacency : graph.adjacencyList) {
            if (wasntVisited(adjacency.key)) {
                bfsQueue.enqueue(graph.getVertex(adjacency.key));
                visitedVertices.add(adjacency.key);
            }
            for (Edge edge : adjacency.edgeList) {
                if (wasntVisited(edge.key)) {
                    bfsQueue.enqueue(graph.getVertex(edge.key));
                    visitedVertices.add(edge.key);
                }
            }
            bfsQueue.dequeue();
        }

        while (bfsQueue.isEmpty()) {
            bfsQueue.dequeue();
        }
    }
}
