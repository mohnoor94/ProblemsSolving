import java.util.Arrays;

/**
 * Assign Numbers in Minesweeper
 * <p>
 * Implement a function that assigns correct numbers in a field of Minesweeper, which is represented as a 2 dimensional
 * array.
 * <p>
 * Example:  The size of the field is 3x4, and there are bombs at the positions [0, 0] (row index = 0, column index = 0)
 * and [0, 1] (row index = 0, column index = 1).
 * Then, the resulting field should be:
 * [[-1, -1, 1, 0],
 * *[2, 2, 1, 0],
 * *[0, 0, 0, 0]]
 * <p>
 * Your function should return the resulting 2D array after taking the following three arguments:
 * 1- bombs: A list of bomb locations.  Given as an array of arrays.  Example: [[0, 0], [0, 1]] ([row index = 0,
 * column index = 0], [row index = 0, column index = 1]. Assume that there are no duplicates.
 * 2- numRows: The number of rows in the resulting field.
 * 3- numCols: The number of columns in the resulting field.
 * <p>
 * In the resulting array:
 * -> -1 represents that there is a bomb in that location.
 * -> 1, 2, 3... etc. represents that there are 1, 2, 3... etc. bombs in the surrounding cells (including diagonally
 * adjacent cells).
 * -> 0 represents that there are no bombs in the surrounding cells.
 * <p>
 * - More details: https://www.udemy.com/11-essential-coding-interview-questions/
 */
public class AssignNumbersInMinesweeper {
    public static void main(String[] args) {
        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(Arrays.deepToString(mineSweeper1(bombs1, 3, 3)));
        // mineSweeper1(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.deepToString(mineSweeper1(bombs2, 3, 4)));
        // mineSweeper1(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(Arrays.deepToString(mineSweeper1(bombs3, 5, 5)));
        // mineSweeper1(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    private static int[][] mineSweeper1(int[][] bombs, int numRows, int numCols) {
        int[][] result = new int[numRows][numCols];
        for (int[] bomb : bombs) result[bomb[0]][bomb[1]] = -1;

        for (int i = 0; i < numRows * numCols; i++) {
            int row = i / numCols;
            int col = i % numCols;

            if (result[row][col] != -1) {
                if (col > 0 && result[row][col - 1] == -1) result[row][col] += 1;
                if (row > 0 && result[row - 1][col] == -1) result[row][col] += 1;
                if (row > 0 && col > 0 && result[row - 1][col - 1] == -1) result[row][col] += 1;

                if (row < numRows - 1 && result[row + 1][col] == -1) result[row][col] += 1;
                if (col < numCols - 1 && result[row][col + 1] == -1) result[row][col] += 1;
                if (row < numRows - 1 && col < numCols - 1 && result[row + 1][col + 1] == -1) result[row][col] += 1;

                if (row > 0 && col < numCols - 1 && result[row - 1][col + 1] == -1) result[row][col] += 1;
                if (row < numRows - 1 && col > 0 && result[row + 1][col - 1] == -1) result[row][col] += 1;
            }
        }
        return result;
    }

    private static int[][] mineSweeper2(int[][] bombs, int numRows, int numCols) {
        int[][] result = new int[numRows][numCols];
        for (int[] bomb : bombs) {
            int rowIndex = bomb[0];
            int colIndex = bomb[1];
            result[rowIndex][colIndex] = -1;
            for (int i = rowIndex - 1; i < rowIndex + 2; i++)
                for (int j = colIndex - 1; j < colIndex + 2; j++)
                    if (0 <= i && i < numRows && 0 <= j && j < numCols && result[i][j] != -1)
                        result[i][j] += 1;
        }
        return result;
    }
}