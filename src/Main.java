import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGISI GRAPH");
        graph.addVertex("A", "ini vertex A");
        graph.addVertex("B", "ini vertex B");
        graph.addVertex("C", "ini vertex C");
        graph.addVertex("D", "ini vertex D");
        graph.addVertex("E", "ini vertex E");
        graph.addVertex("F", "ini vertex F");
        graph.addVertex("G", "ini vertex G");
        graph.addVertex("H", "ini vertex H");
        graph.addVertex("I", "ini vertex I");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHUBUNGKAN VERTICES");
        graph.addAdjacency("A", "B", 100);
        graph.addAdjacency("A", "C");
        graph.addAdjacency("A", "D", 20);
        graph.addAdjacency("A", "E", 15);
        graph.addAdjacency("B", "F");
        graph.addAdjacency("D", "G");
        graph.addAdjacency("F", "H");
        graph.addAdjacency("G", "I");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENCARI VERTEX DENGAN KEY \"I\"");
        if (graph.findVertex("I")) {
            System.out.println("KETEMU");
        } else {
            System.out.println("GAK KETEMU");
        }

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENCARI VERTEX DENGAN KEY \"Z\"");
        if (graph.findVertex("Z")) {
            System.out.println("KETEMU");
        } else {
            System.out.println("GAK KETEMU");
        }

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHAPUS VERTEX DENGAN KEY \"I\"");
        graph.deleteVertex("I");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " SEMUA ADJACENCIES");
        graph.printAllAdjacencies();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHAPUS ADJACENCY ANTAR VERTICES DENGAN KEY \"B\" DAN \"F\"");
        graph.deleteEdge("B", "F");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " SEMUA ADJACENCIES");
        graph.printAllAdjacencies();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " BREADTH FIRST SEARCH");
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        bfs.go();
    }
}
