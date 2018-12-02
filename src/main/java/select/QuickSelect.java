package select;

/**
 * Hoare Algorithm
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] nums1 = {5, 2, 3, 6, 4, -9, -3, 8, 0, 1, 8};
        System.out.println(select(nums1, 2));
        System.out.println(select(nums1, 4));
        // System.out.println(select(nums1, 20));
        // System.out.println(select(nums1, 0));
    }

    static int select(int[] nums, int k) {
        if (k > nums.length || k < 1)
            throw new RuntimeException("k is out of bounds! {array size: " + nums.length + ", k: " + k + "}");
        return select(nums, 0, nums.length - 1, k - 1);
    }

    private static int select(int[] nums, int first, int last, int k) {
        int pivot = partition(nums, first, last);

        if (pivot > k) return select(nums, first, pivot - 1, k);
        else if (pivot < k) return select(nums, pivot + 1, last, k);

        return nums[k];
    }


    /*
     * We could do better and achieve O(n) time complexity if we choose the pivot to be the (approximate) median!
     * that will require an additional memory of (log n) in the worst case.
     * (Median od medians algorithm).
     */
    private static int partition(int[] nums, int first, int last) {
        int pivot = (first + last) / 2; // or: pivot = new Random().nextInt(last - first + 1) + first;
        swap(nums, last, pivot);

        for (int i = first; i < last; i++) {
            if (nums[i] > nums[last]) { // use < to select smallest k-th item
                swap(nums, i, first);
                first++;
            }
        }

        swap(nums, first, last);
        return first;
    }

    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

}
