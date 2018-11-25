package search;


/**
 * A util class to use search method outside this package
 */
public class Search {

    public static int binarySearch(int[] sortedArray, int goal) {
        return BinarySearch.binarySearch(sortedArray, goal);
    }

    public static int linearSearch(int[] array, int goal) {
        return LinearSearch.linearSearch(array, goal);
    }
}