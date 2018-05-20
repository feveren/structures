package graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 矩阵的横向是出度；纵向是入度
 */
public class Graph {
    private static final int MAX = 999;
    private int[][] matrix;
    private int size;
    private boolean[] isVisited;

    public Graph(int size) {
        this.matrix = new int[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j) {
                    matrix[i][j] = MAX;
                }
            }
        }
    }

    public void add(int begin, int end, int weight) {
        this.matrix[begin][end] = weight;
    }

    public void addUndirected(int begin, int end, int weight) {
        this.matrix[begin][end] = weight;
        this.matrix[end][begin] = weight;
    }

    /**
     * 矩阵的横向是出度
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] > 0 && matrix[index][i] < MAX) {
                degree++;
                System.out.println("begin: " + index + "; end: " + i + "; weight: " + matrix[index][i]);
            }
        }
        return degree;
    }

    /**
     * 矩阵的纵向是入度
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[i][index] > 0 && matrix[i][index] < MAX) {
                degree++;
                System.out.println("begin: " + i + "; end: " + index + "; weight: " + matrix[i][index]);
            }
        }
        return degree;
    }

    /**
     * 深度遍历
     * 从图的某个顶点出发，遍历他的第一个邻接点，然后遍历的第一个邻接点的连接点，直到第一邻接点都遍历完成
     * 然后遍历第二个邻接点，直到遍历完成
     * 类似于树的先序遍历
     */
    public void depthFirstSearch() {
        isVisited = new boolean[size];

        for (int i = 0; i < size; i++) {
            // 假如是有序图，有可能有些节点无法遍历到
            // 有些孤立的顶点也无法访问到
            // 所以需要对节点依次遍历
            if (!isVisited[i]) {
                System.out.println("访问节点: " + i);
                depthFirstSearch(i);
            }
        }
    }

    private void depthFirstSearch(int index) {
        isVisited[index] = true;
        int next = getFirstNeighbor(index);
        while (next != -1) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                System.out.println("访问节点: " + next);
                depthFirstSearch(next);
            }
            next = getFirstNeighbor(index, next);
        }
    }

    /**
     * 广度遍历
     * 先遍历顶点，然后遍历他的邻接点，然后再遍历每个邻接点的邻接点，直到遍历完成
     * 类似树的层级遍历
     * 可以使用队列来实现
     */
    public void boardFirstSearch() {
        isVisited = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                boardFirstSearch(i);
            }
        }
    }

    private void boardFirstSearch(int index) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(index);
        while (!queue.isEmpty()) {
            int first = queue.poll();
            isVisited[first] = true;
            System.out.println("访问节点: " + first);
            int next = getFirstNeighbor(first);
            while (next != -1) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
                next = getFirstNeighbor(first, next);
            }
        }
    }

    /**
     * 获取第一个邻接点
     */
    private int getFirstNeighbor(int index) {
        return getFirstNeighbor(index, -1);
    }

    /**
     * 获取i的下一个邻接节点
     */
    private int getFirstNeighbor(int index, int base) {
        for (int i = base + 1; i < matrix[index].length; i++) {
            if (matrix[index][i] > 0 && matrix[index][i] < MAX) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; matrix != null && i < matrix.length; i++) {
            builder.append(Arrays.toString(matrix[i]))
                    .append("\n");
        }
        return builder.toString();
    }
}
