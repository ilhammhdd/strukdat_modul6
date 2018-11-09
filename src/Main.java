import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGISI GRAPH");
        graph.addVertex("pertama", "ini vertex pertama");
        graph.addVertex("kedua", "ini vertex kedua");
        graph.addVertex("ketiga", "ini vertex ketiga");
        graph.addVertex("keempat", "ini vertex keempat");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHUBUNGKAN VERTICES");
        graph.addAdjacency("pertama", "ketiga", 100);
        graph.addAdjacency("kedua", "pertama");
        graph.addAdjacency("kedua", "ketiga");
        graph.addAdjacency("kedua", "keempat");
        graph.addAdjacency("keempat", "ketiga", 20);
        graph.addAdjacency("keempat", "pertama", 15);
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENCARI VERTEX DENGAN KEY \"kedua\"");
        if (graph.findVertex("kedua")) {
            System.out.println("KETEMU");
        } else {
            System.out.println("GAK KETEMU");
        }

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENCARI VERTEX DENGAN KEY \"keseratus\"");
        if (graph.findVertex("keseratus")) {
            System.out.println("KETEMU");
        } else {
            System.out.println("GAK KETEMU");
        }

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHAPUS VERTEX DENGAN KEY \"kedua\"");
        graph.deleteVertex("kedua");
        graph.printAll();

        System.out.println("\n" + new Timestamp(System.currentTimeMillis()) + " MENGHAPUS ADJACENCY VERTICES DENGAN KEY \"pertama\" DAN \"keempat\"");
        graph.deleteAdjacency("pertama", "keempat");
        graph.printAll();
    }
}
