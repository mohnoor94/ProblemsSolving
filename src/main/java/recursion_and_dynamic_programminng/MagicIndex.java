package recursion_and_dynamic_programminng;

/**
 * A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists,
 * in array A.
 * ***
 * FOLLOW UP:
 * What if the values are not distinct?
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.3)
 */
public class MagicIndex {

    public static void main(String[] args) {
        System.out.println(findMagicIndexNoDupsBruteForce(new int[]{-2, -1, 1, 3, 4, 9}));
        System.out.println(findMagicIndexNoDups(new int[]{-2, -1, 1, 3, 4, 9}));
        System.out.println();

        System.out.println(findMagicIndexNoDupsBruteForce(new int[]{-2, -1, 1, 2, 4, 9}));
        System.out.println(findMagicIndexNoDups(new int[]{-2, -1, 1, 2, 4, 9}));
        System.out.println();

        System.out.println(findMagicIndexNoDupsBruteForce(new int[]{-2, -1, 4, 6, 9, 12}));
        System.out.println(findMagicIndexNoDups(new int[]{-2, -1, 4, 6, 9, 12}));
        System.out.println();

        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 1, 3, 4, 9}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 1, 3, 4, 9}));
        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 4, 6, 9, 12}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 4, 6, 9, 12}));
        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 4, 4, 4, 5}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 4, 4, 4, 5}));
        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 4, 4, 5, 6}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 4, 4, 5, 6}));
        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 3, 4, 5, 5}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 3, 4, 5, 5}));
        System.out.println();

        System.out.println(findMagicIndexWithDupsBruteForce(new int[]{-2, -1, 3, 4, 5, 5, 6}));
        System.out.println(findMagicIndexWithDups(new int[]{-2, -1, 3, 4, 5, 5, 6}));
        System.out.println();
    }

    /**
     * Time:    O(n)
     * Space:   In place
     */
    private static int findMagicIndexNoDupsBruteForce(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] == i) return i;
            if (arr[i] > i) break;
            i += 1;
        }

        return -1;
    }

    /**
     * Time:    O(n)
     * Space:   In place
     */
    private static int findMagicIndexWithDupsBruteForce(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] == i) return i;
            if (arr[i] > i) {
                if (arr[i] < arr.length) i = arr[i];
                else break;
            } else {
                i++;
            }
        }

        return -1;
    }

    /**
     * Time:    O(log (n))
     * Space:   In place
     *
     * @return ANY magic index (not necessarily the first).
     */
    private static int findMagicIndexNoDups(int[] arr) {
        return findMagicIndexNoDups(arr, 0, arr.length - 1);
    }

    private static int findMagicIndexNoDups(int[] arr, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;

        if (arr[mid] > mid) return findMagicIndexNoDups(arr, first, mid - 1);
        if (arr[mid] < mid) return findMagicIndexNoDups(arr, mid + 1, last);

        return mid;
    }

    /**
     * Time:    O(log (n))
     * Space:   In place
     */
    private static int findMagicIndexWithDups(int[] arr) {
        return findMagicIndexWithDups(arr, 0, arr.length - 1);
    }

    private static int findMagicIndexWithDups(int[] arr, int first, int last) {
        if (first > last) return -1;

        int midIndex = (first + last) / 2;
        int midValue = arr[midIndex];

        if (midIndex == midValue) return midIndex;

        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = findMagicIndexWithDups(arr, first, leftIndex);
        if (left >= 0) return left;

        int rightIndex = Math.max(midIndex + 1, midValue);

        return findMagicIndexWithDups(arr, rightIndex, last);
    }
}
