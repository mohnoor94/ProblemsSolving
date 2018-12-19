/**
 * 829. Consecutive Numbers Sum
 * ***
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * ***
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * ***
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * ***
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * ***
 * Note: 1 <= N <= 10 ^ 9.
 * ***
 * - Source: Leetcode - https://leetcode.com/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSumFirstSolution(1));
        System.out.println(consecutiveNumbersSumFirstSolution(5));
        System.out.println(consecutiveNumbersSumFirstSolution(9));
        System.out.println(consecutiveNumbersSumFirstSolution(10));
        System.out.println(consecutiveNumbersSumFirstSolution(15));
        System.out.println(consecutiveNumbersSumFirstSolution(43156417));
        System.out.println(consecutiveNumbersSumFirstSolution(68188380));

        System.out.println("*****");

        System.out.println(consecutiveNumbersSumSecondSolution(1));
        System.out.println(consecutiveNumbersSumSecondSolution(5));
        System.out.println(consecutiveNumbersSumSecondSolution(9));
        System.out.println(consecutiveNumbersSumSecondSolution(10));
        System.out.println(consecutiveNumbersSumSecondSolution(15));
        System.out.println(consecutiveNumbersSumSecondSolution(43156417));
        System.out.println(consecutiveNumbersSumSecondSolution(68188380));

        System.out.println("*****");

        // TODO check LeetCode solution. They use a mathematical trick to speed up the solution :3
    }

    /**
     * Time Limit Exceeded on LeetCode
     */
    private static int consecutiveNumbersSumSecondSolution(int num) {
        int count = 1;
        int mid = num / 2 + (num % 2 == 0 ? 0 : 1);
        int sum = 0;
        int start = 1;
        int i = start;

        while (i <= mid) {
            if (sum == 0 && i >= mid) break;
            sum += i;
            if (sum == num) {
                count++;
                sum = 0;
                i = ++start;
            } else if (sum > num) {
                sum = 0;
                i = ++start;
            } else {
                i++;
            }
        }

        return count;
    }

    /**
     * Time Limit Exceeded on LeetCode
     */
    private static int consecutiveNumbersSumFirstSolution(int num) {
        if (num == 1) return 1;
        int count = 1;
        int mid = num / 2 + (num % 2 == 0 ? 0 : 1);
        int sum = 0;

        for (int i = mid; i > 0; i--) {
            sum += i;
            if (sum == num) {
                count++;
                i = mid--;
                sum = 0;
            } else if (sum > num) {
                i = mid--;
                sum = 0;
            }
            if (i == 1 && sum <= num) {
                break;
            }
        }

        return count;
    }
}
