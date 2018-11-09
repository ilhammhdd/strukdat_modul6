public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("pertama", "ini vertex pertama");
        graph.addVertex("kedua", "ini vertex kedua", new String[]{"ketiga"});
        graph.addVertex("ketiga", "ini vertex ketiga", new String[]{"pertama", "kedua"});
        graph.addVertex(
                "keempat",
                "ini vertex keempat",
                new Adjacency[]{
                        new Adjacency("ketiga", 80),
                        new Adjacency("pertama", 10)
                });
        graph.printAll();

        if (graph.findVertex("kedua")){
            System.out.println("kedua ketemu");
        }else{
            System.out.println("kedua gak ketemu");
        }

        graph.deleteVertex("kedua");
        System.out.println("Setelah dihapus kedua");
        graph.printAll();

        if (graph.findVertex("kedua")){
            System.out.println("kedua ketemu");
        }else{
            System.out.println("kedua gak ketemu");
        }

        graph.deleteEdge("pertama", "keempat");
        System.out.println("Setelah dihapus edge yang menghubungkan pertama dan keempat");
        graph.printAll();

        graph.getVertex("pertama");
    }
}
