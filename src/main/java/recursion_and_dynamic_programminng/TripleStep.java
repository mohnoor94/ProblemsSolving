package recursion_and_dynamic_programminng;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement
 * a method to count how many possible ways the child can run up the stairs.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.1)
 */
public class TripleStep {

    public static void main(String[] args) {
        System.out.println(countWays(0));
        System.out.println(countWays(1));
        System.out.println(countWays(2));
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(10));
        System.out.println(countWays(15));
    }

    private static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];

        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);

        return memo[n];
    }
}
