package graph;

import java.util.Arrays;

/**
 * 普利姆算法
 * 找到0到邻接点的最短距离，并将其记录到数组中，并将该点标记为已访问。
 * 然后以该邻接点为起点，找到所有未被访问的邻接点，并将距离记录到数组中。
 * 找到数组中最小的值，该点就是访问的最短距离，然后再以该节点出发，进行寻找。
 */
public class GraphPrim {
    private static final int MAX = 999;
    private int[][] matrix;
    private int size;

    public GraphPrim(int size) {
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

    public void minTree() {
        int[] lowest = matrix[0];
        int min, minIndex, sum = 0;
        for (int i = 1; i < size; i++) {
            min = MAX;
            minIndex = 0;
            for (int j = 0; j < lowest.length; j++) {
                if (lowest[j] > 0 && lowest[j] < MAX && min > lowest[j]) {
                    min = lowest[j];
                    minIndex = j;
                }
            }
            // 获取到最短的路径
            System.out.println("index: " + minIndex + "; weight: " + lowest[minIndex]);
            sum += lowest[minIndex];
            lowest[minIndex] = 0;
            for (int j = 0; j < lowest.length; j++) {
                int weight = matrix[minIndex][j];
                if (weight > 0 && weight < MAX && weight < lowest[j]) {
                    lowest[j] = weight;
                }
            }
        }
        System.out.println(sum);
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
