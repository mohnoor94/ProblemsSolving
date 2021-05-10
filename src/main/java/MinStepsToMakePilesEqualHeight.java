import java.util.Arrays;

/**
 * *** 'Microsoft' interview question ***
 * ***
 * Alexa is given n piles of equal or unequal heights.
 * In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it
 * equal to the one which is just lower than the maximum height of the stack. Determine the minimum number of steps
 * required to make all of the piles equal in height.
 * ---
 * Example 1:
 * Input: piles = [5, 2, 1]
 * Output: 3
 * Explanation:
 * Step 1: reducing 5 -> 2 [2, 2, 1]
 * Step 2: reducing 2 -> 1 [2, 1, 1]
 * Step 3: reducing 2 -> 1 [1, 1, 1]
 * So final number of steps required is 3.
 * ***
 * https://leetcode.com/discuss/interview-question/364618/
 */
public class MinStepsToMakePilesEqualHeight {

    /**
     * Time: O(n lg n) - for sorting
     * Space: O(n) - for sorting (or O(1) if implemented in-place)
     * -
     * n: number of piles.
     */
    public int minSteps(int[] piles) {
        if (piles.length <= 1) return 0;

        int changes = 0;

        Arrays.sort(piles);

        int distinctNumbers = 0;
        for (int i = piles.length - 1; i >= 1; i--) {
            if (piles[i] != piles[i - 1]) {
                ++distinctNumbers;
            }

            changes += distinctNumbers; // count and calculate result in one step!
        }

        return changes;
    }

    // Light tests
    public static void main(String[] args) {
        final MinStepsToMakePilesEqualHeight solution = new MinStepsToMakePilesEqualHeight();
        solution.printResult(new int[]{5, 2, 1}, 3);
        solution.printResult(new int[]{1, 2, 2, 3, 3, 4}, 9);
        solution.printResult(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4}, 15);
    }

    private void printResult(int[] input, int expectedOutput) {
        if (minSteps(input) == expectedOutput)
            System.out.println("Passed, minSteps(" + Arrays.toString(input) + ") = " + expectedOutput);
        else
            System.out.println("Failed, minSteps(" + Arrays.toString(input) + ") should be " + expectedOutput);
    }
}
