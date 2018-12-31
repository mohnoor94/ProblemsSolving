package sort;

@SuppressWarnings("WeakerAccess")
public class MergeSort {

    /**
     * Time:    O(n log(n)); avg and worst cases
     * Space:   O(n)
     * n is the size of the array
     */
    public void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, helper, left, mid);
            mergeSort(array, helper, mid + 1, right);
            merge(array, helper, left, mid, right);
        }
    }

    private void merge(int[] array, int[] helper, int leftStart, int leftEnd, int rightEnd) {
        int left = leftStart;
        int right = leftEnd + 1;
        int pointer = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] < array[right]) {
                helper[pointer] = array[left];
                left++;
            } else {
                helper[pointer] = array[right];
                right++;
            }
            pointer++;
        }

        while (left <= leftEnd) {
            helper[pointer] = array[left];
            left++;
            pointer++;
        }

        while (right <= rightEnd) {
            helper[pointer] = array[right];
            right++;
            pointer++;
        }

        System.arraycopy(helper, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}
