import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Graph {

    private List<Vertex> vertexList;
    private List<Adjacency> adjacencyList;

    public Graph() {
        this.vertexList = new ArrayList<>();
        this.adjacencyList = new ArrayList<>();
    }

    public void addVertex(String key, String data) {
        Vertex newVertex = new Vertex(key, data);
        this.vertexList.add(newVertex);

        Adjacency adjacency = new Adjacency(key);
        this.adjacencyList.add(adjacency);
    }

    public void addAdjacency(String key, String adjacentKey) {
        for (Adjacency adjacency : this.adjacencyList) {
            if (adjacency.key.equals(key)) {
                adjacency.adjacentList.add(new Adjacent(adjacentKey));
            }
            if (adjacency.key.equals(adjacentKey)) {
                adjacency.adjacentList.add(new Adjacent(key));
            }
        }
    }

    public void addAdjacency(String key, String adjacentKey, int weight) {
        for (Adjacency adjacency : this.adjacencyList) {
            if (adjacency.key.equals(key)) {
                adjacency.adjacentList.add(new Adjacent(adjacentKey, weight));
            }
            if (adjacency.key.equals(adjacentKey)) {
                adjacency.adjacentList.add(new Adjacent(key, weight));
            }
        }
    }

    public boolean findVertex(String key) {
        for (Vertex currentVertex : this.vertexList) {
            if (currentVertex.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Vertex getVertex(String key) {
        for (Vertex currentVertex : this.vertexList) {
            if (currentVertex.key.equals(key)) {
                System.out.println("-----------------------------------------");
                System.out.println("Vertex key : " + currentVertex.key);
                System.out.println("Vertex data : " + currentVertex.data);
                System.out.println("-----------------------------------------");
                return currentVertex;
            }
        }
        return null;
    }

    public void deleteVertex(String key) {
        for (int i = 0; i < this.vertexList.size(); i++) {
            if (this.vertexList.get(i).key.equals(key)) {
                this.vertexList.remove(i);
            }
        }

        deleteAdjacent(key);
    }

    public void deleteAdjacent(String key) {
        for (Adjacency anAdjacencyList : this.adjacencyList) {
            for (int j = 0; j < anAdjacencyList.adjacentList.size(); j++) {
                if (anAdjacencyList.adjacentList.get(j).key.equals(key)) {
                    anAdjacencyList.adjacentList.remove(j);
                }
            }
        }
    }

    public void deleteAdjacency(String key, String adjacentKey) {
        for (Adjacency adjacency : this.adjacencyList) {
            if (adjacency.key.equals(key)) {
                for (int i = 0; i < adjacency.adjacentList.size(); i++) {
                    if (adjacency.adjacentList.get(i).key.equals(adjacentKey)) {
                        adjacency.adjacentList.remove(i);
                    }
                }
            } else if (adjacency.key.equals(adjacentKey)) {
                for (int i = 0; i < adjacency.adjacentList.size(); i++) {
                    if (adjacency.adjacentList.get(i).key.equals(key)) {
                        adjacency.adjacentList.remove(i);
                    }
                }
            }
        }
    }

    public void breadthFirstSearch(String startKey) {

    }

    public void printAll() {
        System.out.println("-----------------------------------------");
        for (Vertex vertex : this.vertexList) {
            System.out.println("Vertex key : " + vertex.key);
            System.out.println("Vertex data : " + vertex.data);
            System.out.println("Adjacent vertices : [ ");
            for (Adjacency adjacency : this.adjacencyList) {
                if (adjacency.key.equals(vertex.key)) {
                    for (Adjacent adjacent : adjacency.adjacentList) {
                        System.out.println("    {");
                        if (adjacent.weight != 0) {
                            System.out.println("        Vertex key : " + adjacent.key);
                            System.out.println("        Weight : " + adjacent.weight + ",");
                            System.out.println("    },");
                            continue;
                        }
                        System.out.println("        Vertex key : " + adjacent.key + ", ");
                        System.out.println("    },");
                    }
                }
            }
            System.out.println("]");
            System.out.println("-----------------------------------------");
        }
    }
}
