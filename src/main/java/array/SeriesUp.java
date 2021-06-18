package array;

import java.util.Arrays;

/**
 * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}
 * (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to
 * sum to exactly n*(n + 1)/2.
 * ***
 * seriesUp(3) → [1, 1, 2, 1, 2, 3]
 * seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
 * seriesUp(2) → [1, 1, 2]
 * ***
 * https://codingbat.com/prob/p104090
 */
public class SeriesUp {

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new int[]{1, 1, 2, 1, 2, 3}, seriesUp(3)));
        System.out.println(Arrays.equals(new int[]{1, 1, 2, 1, 2, 3, 1, 2, 3, 4}, seriesUp(4)));
        System.out.println(Arrays.equals(new int[]{1, 1, 2}, seriesUp(2)));
        System.out.println(Arrays.equals(new int[]{1}, seriesUp(1)));
        System.out.println(Arrays.equals(new int[]{}, seriesUp(0)));
        System.out.println(Arrays.equals(new int[]{1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6}, seriesUp(6)));
    }

    /**
     * Time: O(n * (n + 1) / 2) = O(n^2)
     * Space: O(n * (n + 1) / 2) = O(n^2)
     * -
     * n: input size
     */
    private static int[] seriesUp(int n) {
        int[] result = new int[n * (n + 1) / 2];
        int p = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++, p++) {
                result[p] = j;
            }
        }

        return result;
    }
}
