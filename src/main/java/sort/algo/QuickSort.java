package sort.algo;

public class QuickSort implements SortAlgorithm {

    /**
     * Time:    O(n log (n)); avg case, O(n^2) worst case
     * Space:   O(log (n))
     * n is the size of the array
     */
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);

        if (index == -1) return;
        if (left < index - 1) quickSort(array, left, index - 1);
        if (index < right) quickSort(array, index, right);
    }

    private int partition(int[] array, int left, int right) {
        if (array == null || array.length == 0) return -1;

        int pivot = array[(left + right) / 2];

        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
