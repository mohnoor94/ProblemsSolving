package graph.implementation;

import java.util.Arrays;

public class UndirectedAdjacencyMatrixGraph {
    private boolean[][] matrix;

    public UndirectedAdjacencyMatrixGraph(int size) {
        this.matrix = new boolean[size][size];
    }

    public UndirectedAdjacencyMatrixGraph(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public int size() {
        return matrix.length;
    }

    public void connect(int child1, int child2) {
        matrix[child1][child2] = true;
        // matrix[child2][child1] = true;  // no need
    }

    public boolean isConnected(int child1, int child2) {
        return matrix[child1][child2] || matrix[child2][child1];
    }

    public void print() {
        System.out.println(Arrays.deepToString(matrix));
    }
}
