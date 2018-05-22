package graph;

import java.util.Stack;

/**
 * 拓补排序
 * 1. 使用邻接表进行存储，数组中存放所有的顶点，并记录入度数。
 *    顶点指向的所有的边，用链表存储，并关联到顶点。
 * 2. 遍历出所有的入度为0的顶点，并放入栈中
 * 3. pop出栈中的元素，并将他指向的顶点入度数减一，如果入度数为0，再次放入栈中
 * 4. 重复3，直到栈中没有元素
 */
public class GraphTopological {
    public static class Vertex {
        int in;
        String data;
        Edge firstEdge;

        public Vertex(String data) {
            this.data = data;
        }
    }

    public static class Edge {
        Vertex vertex;
        Edge next;

        public Edge(Vertex vertex) {
            this.vertex = vertex;
        }
    }

    private Vertex[] vertices;

    public GraphTopological(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public void sort() {
        Stack<Vertex> stack = new Stack<>();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].in == 0) {
                stack.push(vertices[i]);
            }
        }
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            System.out.println(vertex.data);
            for (Edge edge = vertex.firstEdge; edge != null; edge = edge.next) {
                Vertex v = edge.vertex;
                v.in--;
                if (v.in == 0) {
                    stack.push(v);
                }
            }
        }
    }
}
