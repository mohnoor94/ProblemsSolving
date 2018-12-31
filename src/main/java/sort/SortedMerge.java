package sort;

import java.util.Arrays;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.1)
 */
public class SortedMerge {

    public static void main(String[] args) {
        int[] smaller = {3, 5, 18};
        int[] larger = initLargerArray();

        System.out.println(Arrays.toString(larger));

        mergeFirstSolution(larger, smaller);

        System.out.println(Arrays.toString(larger));

        System.out.println("**********************");

        larger = initLargerArray();

        System.out.println(Arrays.toString(larger));

        mergeSecondSolution(larger, smaller);

        System.out.println(Arrays.toString(larger));
    }

    private static void mergeSecondSolution(int[] larger, int[] smaller) {
        int pl = larger.length - 1 - smaller.length;
        int ps = smaller.length - 1;

        for (int i = larger.length - 1; ps >= 0; i--) {
            if (smaller[ps] > larger[pl]) larger[i] = smaller[ps--];
            else larger[i] = larger[pl--];
        }
    }

    private static void mergeFirstSolution(int[] larger, int[] smaller) {
        int p = 0;
        while (p < larger.length && larger[p] <= smaller[0]) p++;

        shiftRight(larger, smaller.length, p);


        int ps = 0;
        int pl = p + smaller.length;

        while (ps < smaller.length && pl < larger.length) {
            if (smaller[ps] < larger[pl]) larger[p] = smaller[ps++];
            else larger[p] = larger[pl++];
            p++;
        }

        while (ps < smaller.length) larger[p++] = larger[ps++];
        while (pl < larger.length) larger[p++] = larger[pl++];
    }

    private static void shiftRight(int[] array, int shift, int startAt) {
        //noinspection ManualArrayCopy
        for (int i = array.length - 1; i >= startAt + shift; i--) array[i] = array[i - shift];
    }

    private static int[] initLargerArray() {
        int[] larger = new int[10];
        larger[0] = 0;
        larger[1] = 2;
        larger[2] = 3;
        larger[3] = 7;
        larger[4] = 9;
        larger[5] = 21;
        larger[6] = 36;
        return larger;
    }
}
