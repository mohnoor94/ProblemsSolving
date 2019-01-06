package sort;

import java.util.Arrays;

/**
 * In an array of integers, a 'peak' is an element which is greater than or equal to the adjacent integers and a
 * 'valley' is an element which is less than or equal to the adjacent integers.
 * For example in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 * ***
 * Example:
 * - Input:     {5, 3, 1, 2, 3}
 * - Output:    {3, 5, 1, 3, 2}
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.11)
 */
public class PeaksAndValleys {

    public static void main(String[] args) {
        test(new int[]{5, 3, 1, 2, 3});
        test(new int[]{5, 3, 1, 2, 3, 7, 9, 6, 2, 1, 4, 0, 6});
        test(new int[]{5, 3, 1, 2, 3, 7, 18, 9, 6, 2, 1, 4, 0, 6});
        test(new int[]{5, 3, 1, 2, 4, 7, 18, 9, 6, 2, -5, 1, 4, 0, 6});
        test(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        test(new int[]{5, -5, -5, -5, 5});
    }

    /**
     * Time:    O(n);   n is the size of the array
     * Space:   In place
     */
    private static void solve2(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            int biggestIndex = maxIndex(arr, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(arr, i, biggestIndex);
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private static int maxIndex(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (max == aValue) return a;
        if (max == bValue) return b;
        return c;
    }

    /**
     * Time:    O(n);   n is the size of the array
     * Space:   In place
     */
    private static void solve1(int[] arr) {
        boolean largerThan = true;
        for (int i = 0; i < arr.length - 1; i++) {
            swapIf(arr, i, i + 1, largerThan);
            largerThan = !largerThan;
        }
    }

    private static void swapIf(int[] arr, int i1, int i2, boolean largerThan) {
        if ((arr[i1] > arr[i2] && largerThan) || (arr[i1] < arr[i2] && !largerThan)) {
            swap(arr, i1, i2);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] + arr[i2];
        arr[i2] = arr[i1] - arr[i2];
        arr[i1] = arr[i1] - arr[i2];
    }

    private static void test(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        System.out.println("Array   >> " + Arrays.toString(arr));
        solve1(arr);
        System.out.println("Sol. #1 >> " + Arrays.toString(arr));
        solve2(copy);
        System.out.println("Sol. #2 >> " + Arrays.toString(copy));
        System.out.println("************");
    }
}
