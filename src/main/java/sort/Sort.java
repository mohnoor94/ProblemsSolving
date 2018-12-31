package sort;

import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Sort {

    public static void quickSort(int[] array) {
        new QuickSort().sort(array);
    }

    public static void mergeSort(int[] array) {
        new MergeSort().sort(array);
    }

    public static void bucketSort(int[] array) {
        new BucketSort().sort(array);
    }
}

@SuppressWarnings("Duplicates")
class SortTest {

    public static void main(String[] args) {
        int[] ints = {71, 53, 98, 27, 79, 40, 30, 65, 86, 11, 2, 15, 92};
        System.out.println(Arrays.toString(ints));

        Sort.quickSort(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();

        ints = new int[]{71, 53, 98, 27, 79, 40, 30, 65, 86, 11, 2, 15, 92};
        System.out.println(Arrays.toString(ints));

        Sort.mergeSort(ints);
        System.out.println(Arrays.toString(ints));

        System.out.println();

        ints = new int[]{71, 53, 98, 27, 79, 40, 30, 65, 86, 11, 2, 15, 92};
        System.out.println(Arrays.toString(ints));

        Sort.bucketSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}