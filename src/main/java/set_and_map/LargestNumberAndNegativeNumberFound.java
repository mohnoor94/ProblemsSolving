package set_and_map;

import scala.Int;

import java.util.HashSet;

/**
 * *** 'Microsoft' interview question ***
 * ***
 * Write a function that, given an array A of N integers, returns the largest integer K > 0 such that both values
 * K and -K exist in array A. If there is no such integer, the function should return 0.
 * ---
 * Example 1:
 * Input: [3, 2, -2, 5, -3]
 * Output: 3
 * ---
 * Example 2:
 * Input: [1, 2, 3, -4]
 * Output: 0
 * ***
 * https://leetcode.com/discuss/interview-question/406031/
 */
public class LargestNumberAndNegativeNumberFound {

    public int getLargest(int[] numbers) {
        final HashSet<Integer> numbersSet = new HashSet<>();
        for (int number : numbers) numbersSet.add(number);

        int max = -1;
        for (Integer num : numbersSet) {
            if (num > max && numbersSet.contains(-num)) {
                max = num;
            }
        }

        return max;
    }

    // light tests
    public static void main(String[] args) {
        final LargestNumberAndNegativeNumberFound solution = new LargestNumberAndNegativeNumberFound();
        System.out.println(solution.getLargest(new int[]{3, 2, -2, 5, -3}) == 3);
        System.out.println(solution.getLargest(new int[]{1, 2, 3, -4}) == -1);
    }
}
