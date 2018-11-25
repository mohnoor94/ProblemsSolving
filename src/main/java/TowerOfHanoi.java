/**
 * Implement a method to solve the popular tower of Hanoi problem.
 * ***
 * Read about the problem: https://en.wikipedia.org/wiki/Tower_of_Hanoi
 * ***
 * - More details: https://www.udemy.com/algorithmic-problems-in-java/
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        solveHanoiTower(3, 'A', 'B', 'C');
        System.out.println("\n=====================================\n");
        solveHanoiTower(4, 'A', 'B', 'C');
    }

    /**
     * Time:    O(2^n)
     * Space:   O(n)
     */
    private static void solveHanoiTower(int n, char rodFrom, char middleRod, char rodTo) {
        if (n == 1) {
            System.out.println("Moving plate 1 from rod '" + rodFrom + "' to rod '" + rodTo + "'");
            return;
        }

        solveHanoiTower(n - 1, rodFrom, rodTo, middleRod);
        System.out.println("Moving plate " + n + " from rod '" + rodFrom + "' to rod '" + rodTo + "'");
        solveHanoiTower(n-1, middleRod, rodFrom, rodTo);
    }
}
