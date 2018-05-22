package graph;

public class Test {
    public static void main(String[] args) {
//        testOutDegree(getGraph1());
//        testInDegree(getGraph1());
//        depthFirstSearch(getGraph2());
//        boardFirstSearch(getGraph2());
//        testGraphPrim(getGraphPrim());
//        testGraphKruskal(getGraphKruskal());
//        testGraphDijkstra(getGraphDijkstra());
        testGraphTopological(getGraphTopological());
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

    private static void testGraphTopological(GraphTopological graph) {
        System.out.println(graph);
        graph.sort();
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

    private static GraphTopological getGraphTopological() {
        GraphTopological.Vertex[] vertices = new GraphTopological.Vertex[14];
        for (int i = 0; i < 14; i++) {
            vertices[i] = new GraphTopological.Vertex("v" + i);
        }
        vertices[0].firstEdge = createEdges(vertices, new int[] {11, 4, 5});
        vertices[1].firstEdge = createEdges(vertices, new int[] {4, 8, 2});
        vertices[2].firstEdge = createEdges(vertices, new int[] {5, 6, 9});
        vertices[2].in = 2;
        vertices[3].firstEdge = createEdges(vertices, new int[] {2, 13});
        vertices[4].firstEdge = createEdges(vertices, new int[] {7});
        vertices[4].in = 2;
        vertices[5].firstEdge = createEdges(vertices, new int[] {8, 12});
        vertices[5].in = 3;
        vertices[6].firstEdge = createEdges(vertices, new int[] {5});
        vertices[6].in = 1;
        vertices[7].in = 2;
        vertices[8].firstEdge = createEdges(vertices, new int[] {7});
        vertices[8].in = 2;
        vertices[9].firstEdge = createEdges(vertices, new int[] {11, 10});
        vertices[9].in = 2;
        vertices[10].firstEdge = createEdges(vertices, new int[] {13});
        vertices[10].in = 1;
        vertices[11].in = 2;
        vertices[12].firstEdge = createEdges(vertices, new int[] {9});
        vertices[12].in = 1;
        vertices[13].in = 2;
        return new GraphTopological(vertices);
    }

    private static GraphTopological.Edge createEdges(GraphTopological.Vertex[] vertices, int[] array) {
        GraphTopological.Edge first = new GraphTopological.Edge(vertices[array[0]]);
        GraphTopological.Edge edge = first;
        for (int i = 1; i < array.length; i++) {
            edge.next = new GraphTopological.Edge(vertices[array[i]]);
            edge = edge.next;
        }
        return first;
    }
}

