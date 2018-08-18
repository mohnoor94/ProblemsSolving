/**
 * Memoization and Dynamic Programming
 * Count The Paths
 * Problem Statement: https://youtu.be/P8Xa2BitN3I?t=4m14s
 */
public class CountThePaths {
    public static void main(String[] args) {
        var map = new boolean[][]{
                {true, true, true, true, true, true, true, true},
                {true, true, false, true, true, true, false, true},
                {true, true, true, true, false, true, true, true},
                {false, true, false, true, true, false, true, true},
                {true, true, false, true, true, true, true, true},
                {true, true, true, false, false, true, false, true},
                {true, false, true, true, true, false, true, true},
                {true, true, true, true, true, true, true, true},
        };
        System.out.println(new CountThePaths().countPaths(map));
    }

    private int countPaths(boolean[][] map) {
        var paths = new int[map.length][map[0].length];
        paths[map.length - 1][map[0].length - 1] = 1;
        for (int row = map.length - 1; row >= 0; row--) {
            for (int col = map[row].length - 1; col >= 0; col--) {
                if (canGoEither(row, col, map))
                    paths[row][col] = paths[row][col + 1] + paths[row + 1][col];
                else if (canGoRight(row, col, map))
                    paths[row][col] = paths[row][col + 1];
                else if (canGoDown(row, col, map))
                    paths[row][col] = paths[row + 1][col];
                // else... keep it as it '0'
            }
        }
        System.out.println("==============================");
        for (int[] path : paths) {
            for (int i : path) {
                System.out.print(i + ",\t");
            }
            System.out.println();
        }
        System.out.println("==============================");
        return paths[0][0];
    }

    private boolean canGoRight(int row, int col, boolean[][] map) {
        return col < map[row].length - 1 && map[row][col + 1];
    }

    private boolean canGoDown(int row, int col, boolean[][] map) {
        return row < map.length - 1 && map[row + 1][col];
    }

    private boolean canGoEither(int row, int col, boolean[][] map) {
        return canGoRight(row, col, map) && canGoDown(row, col, map);
    }
}