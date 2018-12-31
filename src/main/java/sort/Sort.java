package sort;

import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Sort {

    public static void quickSort(int[] array) {
        new QuickSort().quickSort(array);
    }

    public static void mergeSort(int[] array) {
        new MergeSort().mergeSort(array);
    }
}

class SortTest {

    public static void main(String[] args) {
        int[] ints = {7, 5, 9, 2, 7, 4, 3, 6, 8, 1, 2, 5, 2};
        System.out.println(Arrays.toString(ints));

        Sort.quickSort(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();

        ints = new int[]{7, 5, 9, 2, 7, 4, 3, 6, 8, 1, 2, 5, 2};
        System.out.println(Arrays.toString(ints));

        Sort.mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}