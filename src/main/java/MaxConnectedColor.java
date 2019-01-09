import java.util.*;

enum Color {Red, Green, Blue}

class Point {
    Color color;
    int row;
    int column;

    Point(Color color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                column == point.column &&
                color == point.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, row, column);
    }

    @Override
    public String toString() {
        return "{" + color +
                ", " + row +
                ", " + column + '}';
    }
}

class Result {
    private Color color;
    int count;

    Result(Color color, int count) {
        this.color = color;
        this.count = count;
    }

    @Override
    public String toString() {
        return '{' + color.toString() + ", " + count + '}';
    }
}

class Grid {
    private Point[][] points;

    Grid(int rows, int columns) {
        points = new Point[rows][columns];
    }

    private List<Point> getNeighbours(Point point) {
        ArrayList<Point> neighbours = new ArrayList<>();
        int r = point.row;
        int c = point.column;
        if (r < points.length - 1) neighbours.add(points[r + 1][c]);
        if (r > 0) neighbours.add(points[r - 1][c]);
        if (c < points[r].length - 1) neighbours.add(points[r][c + 1]);
        if (c > 0) neighbours.add(points[r][c - 1]);
        return neighbours;
    }

    void setPoint(Point point) {
        points[point.row][point.column] = point;
    }

    Result getMaxConnectedColor() {
        HashSet<Point> visited = new HashSet<>();
        Result result = new Result(null, 0);
        for (Point[] row : points) {
            for (Point point : row) {
                if (!visited.contains(point)) {
                    visited.add(point);
                    int count = countSimilarNeighbours(point, visited);
                    result = count > result.count ? new Result(point.color, count) : result;
                }
            }
        }

        return result;
    }

    private int countSimilarNeighbours(Point point, HashSet<Point> visited) {
        int counter = 1;

        for (Point neighbour : getNeighbours(point)) {
            if (!visited.contains(neighbour) && neighbour.color == point.color) {
                visited.add(neighbour);
                counter += countSimilarNeighbours(neighbour, visited);
            }
        }

        return counter;
    }

    void print() {
        for (Point[] row : points) {
            System.out.print("| ");
            for (Point point : row) {
                System.out.printf("%-5s | ", point.color);
            }
            System.out.println();
        }
    }
}


/**
 * *** 'Google' interview question ***
 * ***
 * Find the maximum number of connected colors in a grid
 * ***
 * Problem statement: https://youtu.be/IWvbPIYQPFM
 */
class MaxConnectedColorTest {

    public static void main(String[] args) {
        test1();
        System.out.println("*****************");
        test2();
    }

    private static void test2() {
        Random random = new Random();
        int rows = random.nextInt(10) + 1;
        int cols = random.nextInt(10) + 1;
        Grid grid = new Grid(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int guess = random.nextInt(3);
                if (guess == 0) grid.setPoint(new Point(Color.Red, i, j));
                else if (guess == 1) grid.setPoint(new Point(Color.Green, i, j));
                else grid.setPoint(new Point(Color.Blue, i, j));
            }
        }

        System.out.println(grid.getMaxConnectedColor());
        grid.print();
    }

    private static void test1() {
        Grid grid = new Grid(3, 4);
        grid.setPoint(new Point(Color.Green, 0, 0));
        grid.setPoint(new Point(Color.Green, 0, 1));
        grid.setPoint(new Point(Color.Blue, 0, 2));
        grid.setPoint(new Point(Color.Blue, 0, 3));
        grid.setPoint(new Point(Color.Green, 1, 0));
        grid.setPoint(new Point(Color.Blue, 1, 1));
        grid.setPoint(new Point(Color.Red, 1, 2));
        grid.setPoint(new Point(Color.Green, 1, 3));
        grid.setPoint(new Point(Color.Blue, 2, 0));
        grid.setPoint(new Point(Color.Red, 2, 1));
        grid.setPoint(new Point(Color.Red, 2, 2));
        grid.setPoint(new Point(Color.Red, 2, 3));

        System.out.println(grid.getMaxConnectedColor());

        grid.print();
    }
}