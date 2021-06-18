package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number
 * of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given
 * array. (Efficiency is not a priority.)
 * ***
 * maxSpan([1, 2, 1, 1, 3]) → 4
 * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
 * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
 * ***
 * https://codingbat.com/prob/p189576
 */
public class MaxSpan {
    public static void main(String[] args) {
        System.out.println(4 == maxSpan(new int[]{1, 2, 1, 1, 3}));
        System.out.println(6 == maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        System.out.println(6 == maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
        System.out.println(3 == maxSpan(new int[]{3, 3, 3}));
        System.out.println(3 == maxSpan(new int[]{3, 9, 3}));
        System.out.println(2 == maxSpan(new int[]{3, 9, 9}));
        System.out.println(1 == maxSpan(new int[]{3, 9}));
        System.out.println(2 == maxSpan(new int[]{3, 3}));
        System.out.println(0 == maxSpan(new int[]{}));
        System.out.println(1 == maxSpan(new int[]{1}));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * -
     * n: numbers length
     */
    private static int maxSpan(int[] numbers) {
        if (numbers == null || numbers.length < 1) return 0;

        Map<Integer, Integer[]> appearances = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (appearances.containsKey(num)) {
                appearances.get(num)[1] = i;
            } else {
                appearances.put(num, new Integer[]{i, i});
            }
        }

        int maxSpan = 0;

        for (Integer[] indices : appearances.values()) {
            maxSpan = Math.max(maxSpan, indices[1] - indices[0]);
        }

        return maxSpan + 1; // by definition of the span
    }
}
