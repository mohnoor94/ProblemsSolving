package recursion_and_dynamic_programminng;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot setting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are 'off limits' such that the robot
 * cannot stop on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.2)
 */
@SuppressWarnings("WeakerAccess")
public class RobotInGrid {

    /*
     * Other possible solutions:
     * - Start from the 'goal cell' and go backward until you hit the 'origin cell'.
     * (I started from the origin and went forward to the goal).
     * - Use dynamic programming to mark the already visited (failed) cells (using a HashSet).
     * (I reused the original grid/maze to do this by marking the visited (failed) cells as 'off limits').
     */
    List<Point> findPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(0, 0));

        if (maze.length == 1 && maze[0].length == 1) return path;

        return findPath(maze, path);
    }

    private List<Point> findPath(boolean[][] maze, ArrayList<Point> path) {
        if (path.isEmpty()) return null;

        Point last = path.get(path.size() - 1);

        if (isGoal(last, maze)) {
            return path;
        }

        if (canGoRight(last, maze)) {
            path.add(new Point(last.row, last.col + 1));
            return findPath(maze, path);
        }

        if (canGoDown(last, maze)) {
            path.add(new Point(last.row + 1, last.col));
            return findPath(maze, path);
        }

        maze[last.row][last.col] = false;
        path.remove(path.size() - 1);
        return findPath(maze, path);
    }

    private boolean canGoDown(Point point, boolean[][] maze) {
        return point.row < maze.length - 1 && maze[point.row + 1][point.col];
    }

    private boolean canGoRight(Point point, boolean[][] maze) {
        return point.col < maze[0].length - 1 && maze[point.row][point.col + 1];
    }

    private boolean isGoal(Point point, boolean[][] maze) {
        return point.row == maze.length - 1 && point.col == maze[0].length - 1;
    }

    class Point {

        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "{" + row + ", " + col + "}";
        }
    }
}

class RobotInGridTest {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        boolean[][] maze1 = {
                {true, true, true, true},
                {true, true, true, false},
                {true, true, false, true},
                {true, true, true, true}
        };

        boolean[][] maze2 = {
                {true, false, true, true},
                {true, true, true, false},
                {true, true, false, true},
                {true, true, true, true}
        };

        boolean[][] maze3 = {
                {true, false, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, true, true, true}
        };

        boolean[][] maze4 = {
                {true, false, true, true},
                {true, false, true, false},
                {true, true, true, true}
        };

        boolean[][] maze5 = {
                {true, true, true, true},
                {true, false, false, true},
                {false, true, true, true}
        };

        boolean[][] maze6 = {
                {false, true, true, true}
        };

        boolean[][] maze7 = {
                {false}
        };

        boolean[][] maze8 = {
                {true, true, true, true},
                {true, false, false, false},
                {false, true, true, true}
        };

        boolean[][] maze9 = {
                {true, true, true, true},
                {true, true, true, false},
                {true, true, false, true}
        };

        RobotInGrid maze = new RobotInGrid();
        System.out.println(maze.findPath(maze1));
        System.out.println(maze.findPath(maze2));
        System.out.println(maze.findPath(maze3));
        System.out.println(maze.findPath(maze4));
        System.out.println(maze.findPath(maze5));
        System.out.println(maze.findPath(maze6));
        System.out.println(maze.findPath(maze7));
        System.out.println(maze.findPath(maze8));
        System.out.println(maze.findPath(maze9));
        System.out.println(maze.findPath(null));
    }
}
