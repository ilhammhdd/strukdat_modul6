import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> allVertices;
    private List<Edge> allEdges;

    public Graph() {
        this.allVertices = new ArrayList<>();
        this.allEdges = new ArrayList<>();
    }

    public boolean addVertex(String key, String data) {
        Vertex newVertex = new Vertex(key, data);
        return this.allVertices.add(newVertex);
    }

    public boolean addVertex(String key, String data, String[] foundVertexKeys) {
        Vertex newVertex = new Vertex(key, data);
        this.allVertices.add(newVertex);

        Vertex foundVertex;
        for (String foundVertexKey : foundVertexKeys) {
            foundVertex = Edge.findAdjacent(foundVertexKey, this.allVertices);
            if (foundVertex != null) {
                boolean addStatus = this.allEdges.add(new Edge(newVertex.key, foundVertex.key));
                if (!addStatus) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean addVertex(String key, String data, Adjacency[] adjacency) {
        Vertex newVertex = new Vertex(key, data);
        this.allVertices.add(newVertex);

        Vertex foundVertex;
        for (Adjacency adjacent : adjacency) {
            foundVertex = Edge.findAdjacent(adjacent.vertexKey, this.allVertices);
            if (foundVertex != null) {
                boolean addStatus = this.allEdges.add(new Edge(newVertex.key, foundVertex.key, adjacent.weight));
                if (!addStatus) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean findVertex(String key) {
        for (Vertex currentVertex : this.allVertices) {
            if (currentVertex.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Vertex getVertex(String key) {
        for (Vertex currentVertex : this.allVertices) {
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

    public boolean deleteVertex(String key) {
        boolean successDeleteVertex = false;
        boolean successDeleteEdge = false;
        for (int i = 0; i < this.allVertices.size(); i++) {
            if (this.allVertices.get(i).key.equals(key)) {
                this.allVertices.remove(i);
                successDeleteVertex = true;
            }
        }
        for (int i = 0; i < this.allEdges.size(); i++) {
            if (this.allEdges.get(i).key.equals(key) || this.allEdges.get(i).adjacentKey.equals(key)) {
                this.allEdges.remove(i);
                successDeleteEdge = true;
            }
        }

        return successDeleteEdge && successDeleteVertex;
    }

    public boolean deleteEdge(String key, String adjacentKey) {
        for (int i = 0; i < this.allEdges.size(); i++) {
            if (this.allEdges.get(i).key.equals(key) && this.allEdges.get(i).adjacentKey.equals(adjacentKey)) {
                this.allEdges.remove(i);
                return true;
            } else if (this.allEdges.get(i).key.equals(adjacentKey) && this.allEdges.get(i).adjacentKey.equals(key)) {
                this.allEdges.remove(i);
                return true;
            }
        }

        return false;
    }

    public void breadthFirstSearch(String startKey) {

    }

    public void printAll() {
        for (Vertex currentVertex : this.allVertices) {
            System.out.println("-----------------------------------------");
            System.out.println("Vertex key : " + currentVertex.key);
            System.out.println("Vertex data : " + currentVertex.data);
            System.out.println("Adjacent vertices : [ ");
            for (Edge currentEdge : this.allEdges) {
                if (currentEdge.key.equals(currentVertex.key)) {
                    System.out.println("    {");
                    if (currentEdge.weight != 0) {
                        System.out.println("        Vertex key : " + currentEdge.adjacentKey);
                        System.out.println("        Weight : " + currentEdge.weight + ",");
                        System.out.println("    },");
                        continue;
                    }
                    System.out.println("        Vertex key : " + currentEdge.adjacentKey + ", ");
                    System.out.println("    },");
                } else if (currentEdge.adjacentKey.equals(currentVertex.key)) {
                    System.out.println("    {");
                    if (currentEdge.weight != 0) {
                        System.out.println("        Vertex key : " + currentEdge.key);
                        System.out.println("        Weight : " + currentEdge.weight + ",");
                        System.out.println("    },");
                        continue;
                    }
                    System.out.println("        Vertex key : " + currentEdge.key + ", ");
                    System.out.println("    },");
                }
            }
            System.out.println("]");
            System.out.println("-----------------------------------------\n");
        }
    }
}
