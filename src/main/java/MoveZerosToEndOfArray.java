import java.util.Arrays;

/**
 * Problem statement: Move all zeros present in an array to the end.
 * <p>
 * - More details: https://youtu.be/VzQ2KacyDLw
 */
public class MoveZerosToEndOfArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 0, 2, 0, 3, 0, 4, 0, 5, 0, 0, 6, 0};

        System.out.println(Arrays.toString(moveZerosToEndPreserveOrder(nums)));

        moveZerosToEndInPlace(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * This method will update the same array in place, but it will not
     * preserve the order of original non-zero elements.
     * <p>
     * Time:    O(n)
     * Space:   O(1) in-place
     */
    private static void moveZerosToEndInPlace(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] != 0) start++;
            if (nums[end] == 0) end--;
            if (start < end && nums[start] == 0 && nums[end] != 0) swap(nums, start, end);
        }
    }

    /**
     * This method will return the result in a new array but it will
     * preserve the order of original non-zero elements.
     * <p>
     * Time:    O(n)
     * Space:   O(n)
     */
    private static int[] moveZerosToEndPreserveOrder(int[] nums) {
        int[] newNums = new int[nums.length]; // initialize a new array of zeros
        int newIndex = 0;

        for (int num : nums) if (num != 0) newNums[newIndex++] = num;

        return newNums;
    }

    private static void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
