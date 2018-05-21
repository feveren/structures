package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 克鲁斯卡算法
 * 以边进行计算，首先将所有的边以距离进行从小到大排序。
 * 然后将边依次放入到数组中，并计算是否有回环，有的话舍弃，没有的话就保留，知道遍历完。
 */
public class GraphKruskal {
    private static final int MAX = 999;
    private List<Edge> edges = new ArrayList<>();
    private int size;
    /**
     * index 为起点，value为终点
     */
    private int[] parent;

    public GraphKruskal(int edgeSize) {
        this.size = edgeSize;
    }

    public void add(int begin, int end, int weight) {
        edges.add(new Edge(begin, end, weight));
    }

    public void minTree() {
        parent = new int[size];
        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            int begin = findParent(edge.begin);
            int end = findParent(edge.end);
            System.out.print("edge.begin: " + edge.begin + "; begin.parent: " + begin + " edge.end: " + edge.end + "; begin.parent: " + end + "; weight: " + edge.weight);
            if (begin != end) {
                parent[begin] = end;
                sum += edge.weight;
                System.out.println(" 加入最小生成树");
            } else {
                System.out.println(" 产生了回环");
            }
        }
        System.out.println(sum);
    }

    private int findParent(int index) {
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }

    private static class Edge {
        int begin;
        int end;
        int weight;

        Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }
}

