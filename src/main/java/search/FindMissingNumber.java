package search;

/**
 * *** 'Google' interview question ***
 * ***
 * Given a contiguous sequence of numbers in which each number repeats thrice, there is exactly one missing number.
 * Find the missing number.
 * eg: 11122333 : Missing number 2
 * 11122233344455666 Missing number 5
 * ***
 * Problem statement: https://leetcode.com/discuss/interview-experience/124626/Google-onsite-interview-questions
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] bigArr1 = getBigArray1();
        int[] bigArr2 = getBigArray2();

        System.out.println(findMissing1(new int[]{1, 1, 1, 2, 2, 3, 3, 3}));
        System.out.println(findMissing1(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(findMissing1(new int[]{1, 1, 2, 2, 2, 3, 3, 3}));
        System.out.println(findMissing1(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
        System.out.println(findMissing1(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6}));
        System.out.println(findMissing1(bigArr1));
        System.out.println(findMissing1(bigArr2));

        System.out.println("***********");

        System.out.println(findMissing2(new int[]{1, 1, 1, 2, 2, 3, 3, 3}));
        System.out.println(findMissing2(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(findMissing2(new int[]{1, 1, 2, 2, 2, 3, 3, 3}));
        System.out.println(findMissing2(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
        System.out.println(findMissing2(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6}));
        System.out.println(findMissing2(bigArr1));
        System.out.println(findMissing2(bigArr2));
    }


    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    private static int findMissing1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            System.out.print(".");
            if (i + 2 >= nums.length || nums[i] != nums[i + 2]) return nums[i];
            i += 3;
        }

        return -1;
    }

    /**
     * Time:    O(log (n))
     * Space:   O(1) ( or log (n) ???)
     */
    private static int findMissing2(int[] nums) {
        return findMissing2(nums, 0, nums.length - 1, -1);
    }

    private static int findMissing2(int[] nums, int start, int end, int memo) {
        if (start > end) return memo;
        System.out.print(".");

        int mid = (start + end) / 2;
        if (mid % 3 != 0) {
            mid = ((mid - 1) % 3 == 0) ? mid - 1 : mid - 2;
        }

        if (mid + 2 >= nums.length) {
            if (memo != -1) return memo;
            return nums[mid];
        }

        if (nums[mid] != nums[mid + 2]) {
            return findMissing2(nums, start, mid - 3, nums[mid]);
        }

        if (memo > nums[mid]) return findMissing2(nums, mid + 3, end, memo);
        return findMissing2(nums, mid + 3, end, -1);
    }

    private static int[] getBigArray1() {
        int[] arr = new int[998];
        for (int i = 0; i < 996; i += 3) {
            arr[i] = arr[i + 1] = arr[i + 2] = i / 3 + 1;
        }

        arr[996] = 333;
        arr[997] = 333;

        return arr;
    }

    private static int[] getBigArray2() {
        int[] arr = new int[998];
        for (int i = 0; i < 111; i += 3) {
            arr[i] = arr[i + 1] = arr[i + 2] = i / 3 + 1;
        }

        arr[111] = 38;
        arr[112] = 38;

        for (int i = 113; i < 996; i += 3) {
            arr[i] = arr[i + 1] = arr[i + 2] = i / 3 + 2;
        }

        return arr;
    }
}
