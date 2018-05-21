package graph;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法
 * 先找到0距离某点X的最小距离，然后以X点为起点，找邻接点，并算出X到邻接点的距离 + 0到X的距离，将值记录到数组中。
 * 找到数组中的最小值，这就是0距离该点的最小值。
 * 然后重复上面的步骤
 */
public class GraphDijkstra {
    private static final int MAX = 999;
    private int[][] matrix;
    private int size;

    public GraphDijkstra(int size) {
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
        this.matrix[end][begin] = weight;
    }

    public void shortest() {
        int[] shortest = matrix[0];
        boolean[] gotShortest = new boolean[size];
        gotShortest[0] = true;
        int minIndex = 0, min;
        for (int i = 1; i < size; i++) {
            min = MAX;
            // 数组中的最小值（还未计算出最小值的值）
            // 也就是0到该点的最短距离
            for (int j = 1; j < shortest.length; j++) {
                if (!gotShortest[j] && min > shortest[j]) {
                    min = shortest[j];
                    minIndex = j;
                }
            }
            gotShortest[minIndex] = true;
            // 然后通过该点，找可以到达的其他点
            // 距离其他点的距离 + min = 0到到达该点的距离
            // 通过和已经有的距离进行比较，算的当前最短距离
            for (int j = 1; j < size; j++) {
                int length = min + matrix[minIndex][j];
                if (!gotShortest[j] && length < shortest[j]) {
                    shortest[j] = length;
                }
            }
        }
        for (int i = 1; i < shortest.length; i++) {
            System.out.println("0到" + i + "的最短距离为" + shortest[i]);
        }
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
