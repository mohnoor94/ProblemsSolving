package array;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one
 * side is equal to the sum of the numbers on the other side.
 * ***
 * canBalance([1, 1, 1, 2, 1]) → true
 * canBalance([2, 1, 1, 2, 1]) → false
 * canBalance([10, 10]) → true
 * ***
 * https://codingbat.com/prob/p158767
 */
public class SumBalance {

    public static void main(String[] args) {
        System.out.println(canBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(!canBalance(new int[]{2, 1, 1, 2, 1}));
        System.out.println(canBalance(new int[]{10, 10}));
        System.out.println(canBalance(new int[]{10, 0, 1, -1, 10}));
        System.out.println(canBalance(new int[]{1, 1, 1, 1, 4}));
        System.out.println(!canBalance(new int[]{2, 1, 1, 1, 4}));
        System.out.println(!canBalance(new int[]{2, 3, 4, 1, 2}));
        System.out.println(canBalance(new int[]{1, 2, 3, 1, 0, 2, 3}));
        System.out.println(!canBalance(new int[]{1, 2, 3, 1, 0, 1, 3}));
        System.out.println(!canBalance(new int[]{1}));
        System.out.println(canBalance(new int[]{1, 1, 1, 2, 1}));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * -
     * n: length of nums
     */
    private static boolean canBalance(int[] nums) {
        int fp = 0;
        int bp = nums.length - 1;
        int fsum = 0;
        int bsum = 0;

        while (bp >= fp) {
            while (fsum <= bsum && fp <= bp) {
                fsum += nums[fp];
                fp += 1;
            }

            while (bsum <= fsum && fp <= bp) {
                bsum += nums[bp];
                bp -= 1;
            }
        }

        return fsum == bsum;
    }
}
