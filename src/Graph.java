import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Vertex> vertexList;
    public List<Adjacency> adjacencyList;

    public Graph() {
        vertexList = new ArrayList<>();
        adjacencyList = new ArrayList<>();
    }

    public void addVertex(String key, String data) {
        Vertex newVertex = new Vertex(key, data);
        vertexList.add(newVertex);

        Adjacency adjacency = new Adjacency(key);
        adjacencyList.add(adjacency);
    }

    public void addAdjacency(String key, String adjacentKey) {
        for (Adjacency adjacency : adjacencyList) {
            if (adjacency.key.equals(key)) {
                adjacency.edgeList.add(new Edge(adjacentKey));
            }
            if (adjacency.key.equals(adjacentKey)) {
                adjacency.edgeList.add(new Edge(key));
            }
        }
    }

    public void addAdjacency(String key, String adjacentKey, int weight) {
        for (Adjacency adjacency : adjacencyList) {
            if (adjacency.key.equals(key)) {
                adjacency.edgeList.add(new Edge(adjacentKey, weight));
            }
            if (adjacency.key.equals(adjacentKey)) {
                adjacency.edgeList.add(new Edge(key, weight));
            }
        }
    }

    public boolean findVertex(String key) {
        for (Vertex currentVertex : vertexList) {
            if (currentVertex.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Vertex getVertex(String key) {
        for (Vertex vertex : vertexList) {
            if (vertex.key.equals(key)) {
                return vertex;
            }
        }
        return null;
    }

    public void deleteVertex(String key) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).key.equals(key)) {
                vertexList.remove(i);
            }
        }

        deleteAdjacency(key);
    }

    public void deleteEdge(String key, String adjacentKey) {
        for (Adjacency anAdjacencyList : adjacencyList) {
            if (anAdjacencyList.key.equals(key)) {
                for (int j = 0; j < anAdjacencyList.edgeList.size(); j++) {
                    if (anAdjacencyList.edgeList.get(j).key.equals(adjacentKey)) {
                        anAdjacencyList.edgeList.remove(j);
                    }
                }
            } else if (anAdjacencyList.key.equals(adjacentKey)) {
                for (int j = 0; j < anAdjacencyList.edgeList.size(); j++) {
                    if (anAdjacencyList.edgeList.get(j).key.equals(key)) {
                        anAdjacencyList.edgeList.remove(j);
                    }
                }
            }
        }
    }

    private void deleteAdjacency(String key) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).key.equals(key)) {
                adjacencyList.remove(i);
                continue;
            }
            for (int j = 0; j < adjacencyList.get(i).edgeList.size(); j++) {
                if (adjacencyList.get(i).edgeList.get(j).key.equals(key)) {
                    adjacencyList.get(i).edgeList.remove(j);
                }
            }
        }
    }

    public Adjacency getAdjacency(String key) {
        for (Adjacency anAdjacencyList : adjacencyList) {
            if (anAdjacencyList.key.equals(key)) {
                return anAdjacencyList;
            }
        }
        return null;
    }

    public void printAllAdjacencies() {
        for (Adjacency adjacency : adjacencyList) {
            System.out.print(adjacency.key + " : ");
            for (Edge edge : adjacency.edgeList) {
                System.out.print(edge.key + ", ");
            }
            System.out.println();
        }
    }

    public void printAll() {
        System.out.println("-----------------------------------------");
        for (Vertex vertex : vertexList) {
            System.out.println("Vertex key : " + vertex.key);
            System.out.println("Vertex data : " + vertex.data);
            System.out.println("Edge vertices : [ ");
            for (Adjacency adjacency : adjacencyList) {
                if (adjacency.key.equals(vertex.key)) {
                    for (Edge edge : adjacency.edgeList) {
                        System.out.println("    {");
                        if (edge.weight != 0) {
                            System.out.println("        Vertex key : " + edge.key);
                            System.out.println("        Weight : " + edge.weight + ",");
                            System.out.println("    },");
                            continue;
                        }
                        System.out.println("        Vertex key : " + edge.key + ", ");
                        System.out.println("    },");
                    }
                }
            }
            System.out.println("]");
            System.out.println("-----------------------------------------");
        }
    }
}
