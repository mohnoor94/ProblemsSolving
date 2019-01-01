package search;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element
 * in the array. You may assume that the array is originally sorted in increasing order.
 * ***
 * Example:
 * - Input:     find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * - Output:    8 (the index of 5 in the array)
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.3)
 */
public class SearchInRotatedArray {

    public static void main(String[] args) {
        testSearchWithNoDups();
        testSearchWithDups();
    }

    /**
     * Time:    O(log (n))
     * Space:   O(log (n)) (for stack?...)
     */
    private static int searchWithNoDups(int[] arr, int goal) {
        return searchWithNoDups(arr, goal, 0, arr.length - 1);
    }

    /**
     * Time:    O(log (n) for all unique items, O(n) if there are repeated items
     * Space:   O(log (n)) (for stack?...)
     */
    private static int searchWithDups(int[] arr, int goal) {
        return searchWithDups(arr, goal, 0, arr.length - 1);
    }

    private static int searchWithNoDups(int[] arr, int goal, int first, int last) {
        if (first > last) return -1;
        int mid = (first + last) / 2;

        if (arr[mid] == goal) return mid;

        if (goal > arr[mid]) {
            if (goal > arr[last]) return searchWithNoDups(arr, goal, first, mid - 1);
            return searchWithNoDups(arr, goal, mid + 1, last);
        }

        return searchWithNoDups(arr, goal, first, mid - 1);
    }

    // this implementation s copied almost as-is from the source above
    private static int searchWithDups(int[] arr, int goal, int first, int last) {
        if (first > last) return -1;
        int mid = (first + last) / 2;

        if (arr[mid] == goal) return mid;

        if (arr[first] < arr[mid]) { // left half is normally ordered
            if (goal >= arr[first] && goal < arr[mid]) return searchWithDups(arr, goal, first, mid - 1); // search left
            return searchWithDups(arr, goal, mid + 1, last); // search right
        } else if (arr[mid] < arr[first]) { // right half is normally ordered
            if (goal > arr[mid] && goal <= arr[last]) return searchWithDups(arr, goal, mid + 1, last); // search right
            return searchWithDups(arr, goal, first, mid - 1); // search left
        } else { // left or right half is all repeats
            if (arr[mid] != arr[last]) return searchWithDups(arr, goal, mid + 1, last); // right is different, search right
            // else, we have to search both halves!
            int result = searchWithDups(arr, goal, first, mid - 1); // search left
            if (result == -1) return searchWithDups(arr, goal, mid + 1, last); // if not in left, search right
            return result;
        }
    }

    private static void testSearchWithDups() {
        int[] arr1 = {4, 5, 6, 6, 7, 1, 1, 1, 2, 3, 3};
        int[] arr2 = {15, 15, 15, 16, 16, 19, 20, 20, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(searchWithNoDups(arr1, 0));
        System.out.println(searchWithNoDups(arr1, 1));
        System.out.println(searchWithNoDups(arr1, 2));
        System.out.println(searchWithNoDups(arr1, 3));
        System.out.println(searchWithNoDups(arr1, 4));
        System.out.println(searchWithNoDups(arr1, 5));
        System.out.println(searchWithNoDups(arr1, 6));
        System.out.println(searchWithNoDups(arr1, 7));
        System.out.println(searchWithNoDups(arr1, 8));

        System.out.println("***");

        System.out.println(searchWithDups(arr2, 15));
        System.out.println(searchWithDups(arr2, 16));
        System.out.println(searchWithDups(arr2, 19));
        System.out.println(searchWithDups(arr2, 20));
        System.out.println(searchWithDups(arr2, 25));
        System.out.println(searchWithDups(arr2, 1));
        System.out.println(searchWithDups(arr2, 3));
        System.out.println(searchWithDups(arr2, 4));
        System.out.println(searchWithDups(arr2, 5));
        System.out.println(searchWithDups(arr2, 7));
        System.out.println(searchWithDups(arr2, 10));
        System.out.println(searchWithDups(arr2, 14));
        System.out.println(searchWithDups(arr2, -5));
        System.out.println(searchWithDups(arr2, 50));
        System.out.println(searchWithDups(arr2, 8));
    }

    private static void testSearchWithNoDups() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(searchWithNoDups(arr, 15));
        System.out.println(searchWithNoDups(arr, 16));
        System.out.println(searchWithNoDups(arr, 19));
        System.out.println(searchWithNoDups(arr, 20));
        System.out.println(searchWithNoDups(arr, 25));
        System.out.println(searchWithNoDups(arr, 1));
        System.out.println(searchWithNoDups(arr, 3));
        System.out.println(searchWithNoDups(arr, 4));
        System.out.println(searchWithNoDups(arr, 5));
        System.out.println(searchWithNoDups(arr, 7));
        System.out.println(searchWithNoDups(arr, 10));
        System.out.println(searchWithNoDups(arr, 14));
        System.out.println(searchWithNoDups(arr, -5));
        System.out.println(searchWithNoDups(arr, 50));
        System.out.println(searchWithNoDups(arr, 8));

        System.out.println("***");
    }
}
