package search;

import java.util.Arrays;

/**
 * *** 'Microsoft' interview question ***
 * ***
 * Given an array of numbers, find the length of the longest increasing subsequence in the array.
 * The subsequence does not necessarily have to be contiguous.
 * ***
 * For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15],
 * the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findLongestSubsequence1(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
        System.out.println(findLongestSubsequence2(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
        System.out.println("***");
        System.out.println(findLongestSubsequence1(new int[]{0, 6, 9, 20, 12, 14}));
        System.out.println(findLongestSubsequence2(new int[]{0, 6, 9, 20, 12, 14}));
        System.out.println("***");
        System.out.println(findLongestSubsequence1(new int[]{20, 18, 15, 3}));
        System.out.println(findLongestSubsequence2(new int[]{20, 18, 15, 3}));
        System.out.println("***");
        System.out.println(findLongestSubsequence1(new int[]{20, 18, 15, 30}));
        System.out.println(findLongestSubsequence2(new int[]{20, 18, 15, 30}));
        System.out.println("***");
        System.out.println(findLongestSubsequence1(new int[]{20, 2, 12, 6, 3, 9, 15, 30, 4}));
        System.out.println(findLongestSubsequence2(new int[]{20, 2, 12, 6, 3, 9, 15, 30, 4}));
        System.out.println("***");
    }

    /**
     * Time:    O(n^2)
     * Space:   O(n)
     */
    private static int findLongestSubsequence2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) cache[i] = Math.max(cache[i], cache[j] + 1);
            }
        }

        int max = cache[0];
        for (int i = 1; i < cache.length; i++) {
            if (cache[i] > max) max = cache[i];
        }

        return max;
    }

    /**
     * Time:    O(n^3) !!!!
     * Space:   O(1)
     */
    private static int findLongestSubsequence1(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int longestSubsequence = 1;
        for (int i = 0; i < nums.length; i++) {
            if (longestSubsequence > nums.length - 1 - i) break;
            int length = findLongestSubsequence1(nums, i + 1, nums.length - 1, nums[i], 1);
            longestSubsequence = length > longestSubsequence ? length : longestSubsequence;
        }
        return longestSubsequence;
    }

    private static int findLongestSubsequence1(int[] nums, int start, int end, int currentMax, int length) {
        if (start > end) return length;

        int maxLength = length;
        for (int i = start; i <= end; i++) {
            if (nums[i] > currentMax) {
                int newLength = findLongestSubsequence1(nums, i, end, nums[i], length + 1);
                maxLength = newLength > maxLength ? newLength : maxLength;
            }
        }

        return maxLength;
    }
}
