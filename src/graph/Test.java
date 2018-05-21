package graph;

public class Test {
    public static void main(String[] args) {
//        testOutDegree(getGraph1());
//        testInDegree(getGraph1());
//        depthFirstSearch(getGraph2());
//        boardFirstSearch(getGraph2());
//        testGraphPrim(getGraphPrim());
//        testGraphKruskal(getGraphKruskal());
        testGraphDijkstra(getGraphDijkstra());
    }

    private static void testOutDegree(Graph graph) {
        System.out.println(graph);

        System.out.println("total: " + graph.getOutDegree(0));
        System.out.println("total: " + graph.getOutDegree(1));
        System.out.println("total: " + graph.getOutDegree(2));
        System.out.println("total: " + graph.getOutDegree(3));
        System.out.println("total: " + graph.getOutDegree(4));
    }

    private static void testInDegree(Graph graph) {
        System.out.println(graph);

        System.out.println("total: " + graph.getOutDegree(0));
        System.out.println("total: " + graph.getOutDegree(1));
        System.out.println("total: " + graph.getOutDegree(2));
        System.out.println("total: " + graph.getOutDegree(3));
        System.out.println("total: " + graph.getOutDegree(4));
    }

    private static void depthFirstSearch(Graph graph) {
        System.out.println(graph);
        graph.depthFirstSearch();
    }

    private static void boardFirstSearch(Graph graph) {
        System.out.println(graph);
        graph.boardFirstSearch();
    }

    private static void testGraphPrim(GraphPrim graph) {
        System.out.println(graph);
        graph.minTree();
    }

    private static void testGraphKruskal(GraphKruskal graph) {
        System.out.println(graph);
        graph.minTree();
    }

    private static void testGraphDijkstra(GraphDijkstra graph) {
        System.out.println(graph);
        graph.shortest();
    }

    private static Graph getGraph1() {
        Graph graph = new Graph(5);
        graph.add(0, 4, 6);
        graph.add(1, 0, 9);
        graph.add(1, 2, 3);
        graph.add(2, 0, 2);
        graph.add(2, 3, 5);
        graph.add(3, 4, 1);
        return graph;
    }

    private static Graph getGraph2() {
        Graph graph = new Graph(9);
        graph.addUndirected(4, 7, 7);
        graph.addUndirected(2, 8, 8);
        graph.addUndirected(0, 1, 10);
        graph.addUndirected(0, 5, 11);
        graph.addUndirected(1, 8, 12);
        graph.addUndirected(3, 7, 16);
        graph.addUndirected(1, 6, 16);
        graph.addUndirected(5, 6, 17);
        graph.addUndirected(1, 2, 18);
        graph.addUndirected(6, 7, 19);
        graph.addUndirected(3, 4, 20);
        graph.addUndirected(3, 8, 21);
        graph.addUndirected(2, 3, 22);
        graph.addUndirected(3, 6, 24);
        graph.addUndirected(4, 5, 26);
        return graph;
    }

    private static GraphPrim getGraphPrim() {
        GraphPrim graph = new GraphPrim(9);
        graph.addUndirected(4, 7, 7);
        graph.addUndirected(2, 8, 8);
        graph.addUndirected(0, 1, 10);
        graph.addUndirected(0, 5, 11);
        graph.addUndirected(1, 8, 12);
        graph.addUndirected(3, 7, 16);
        graph.addUndirected(1, 6, 16);
        graph.addUndirected(5, 6, 17);
        graph.addUndirected(1, 2, 18);
        graph.addUndirected(6, 7, 19);
        graph.addUndirected(3, 4, 20);
        graph.addUndirected(3, 8, 21);
        graph.addUndirected(2, 3, 22);
        graph.addUndirected(3, 6, 24);
        graph.addUndirected(4, 5, 26);
        return graph;
    }

    private static GraphKruskal getGraphKruskal() {
        GraphKruskal graph = new GraphKruskal(14);
        graph.add(4, 7, 7);
        graph.add(2, 8, 8);
        graph.add(0, 1, 10);
        graph.add(0, 5, 11);
        graph.add(1, 8, 12);
        graph.add(3, 7, 16);
        graph.add(1, 6, 16);
        graph.add(5, 6, 17);
        graph.add(1, 2, 18);
        graph.add(6, 7, 19);
        graph.add(3, 4, 20);
        graph.add(3, 8, 21);
        graph.add(2, 3, 22);
        graph.add(3, 6, 24);
        graph.add(4, 5, 26);
        return graph;
    }

    private static GraphDijkstra getGraphDijkstra() {
        GraphDijkstra graph = new GraphDijkstra(9);
        graph.add(0, 1, 1);
        graph.add(0, 2, 5);
        graph.add(1, 2, 3);
        graph.add(1, 3, 7);
        graph.add(1, 4, 5);
        graph.add(2, 4, 1);
        graph.add(2, 5, 7);
        graph.add(3, 4, 2);
        graph.add(3, 6, 3);
        graph.add(4, 5, 3);
        graph.add(4, 6, 6);
        graph.add(4, 7, 9);
        graph.add(5, 7, 5);
        graph.add(6, 7, 2);
        graph.add(6, 8, 7);
        graph.add(7, 8, 4);
        return graph;
    }
}
