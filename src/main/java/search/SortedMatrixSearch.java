package search;

/**
 * Given an M x N matrix in which each row and each column is sorted in ascending order.
 * Write a method to find an element.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.9)
 */
public class SortedMatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {2, 3, 3, 6, 9, 11},
                {5, 6, 7, 8, 10, 12},
                {5, 8, 11, 13, 15, 20}
        };

        System.out.println(find(matrix, 7));
        System.out.println(find(matrix, 8));
        System.out.println(find(matrix, 5));
        System.out.println(find(matrix, 14));
    }

    private static Index find(int[][] matrix, int goal) {
        int r = 0;
        int c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == goal) return new Index(r, c);
            if (matrix[r][c] > goal) c--;
            else r++;
        }

        return null;
    }
}

class Index {
    private int row;
    private int col;

    Index(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "{" + row + ", " + col + "}";
    }
}