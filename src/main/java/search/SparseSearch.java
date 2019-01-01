package search;

/**
 * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a
 * given string.
 * ***
 * Example:
 * - Input:     "ball",  {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * - Output:    4
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.5)
 */
public class SparseSearch {

    public static void main(String[] args) {
        String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(searchFirstSolution(arr, "at"));
        System.out.println(searchFirstSolution(arr, "ball"));
        System.out.println(searchFirstSolution(arr, "car"));
        System.out.println(searchFirstSolution(arr, "dad"));
        System.out.println(searchFirstSolution(arr, "hi"));
        System.out.println(searchFirstSolution(arr, "an"));
        System.out.println(searchFirstSolution(arr, "az"));

        System.out.println("***");

        System.out.println(searchSecondSolution(arr, "at"));
        System.out.println(searchSecondSolution(arr, "ball"));
        System.out.println(searchSecondSolution(arr, "car"));
        System.out.println(searchSecondSolution(arr, "dad"));
        System.out.println(searchSecondSolution(arr, "hi"));
        System.out.println(searchSecondSolution(arr, "an"));
        System.out.println(searchSecondSolution(arr, "az"));
    }

    private static int searchFirstSolution(String[] arr, String goal) {
        return searchFirstSolution(arr, goal, 0, arr.length - 1);
    }

    private static int searchFirstSolution(String[] arr, String goal, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;
        int midCopy = mid;

        while (arr[mid].isEmpty()) {
            mid++;
            if (mid > last) return searchFirstSolution(arr, goal, first, midCopy - 1);
        }

        int comparison = arr[mid].compareTo(goal);
        if (comparison > 0) return searchFirstSolution(arr, goal, first, mid - 1);
        if (comparison < 0) return searchFirstSolution(arr, goal, mid + 1, last);

        return mid;
    }

    private static int searchSecondSolution(String[] arr, String goal) {
        return searchSecondSolution(arr, goal, 0, arr.length - 1);
    }

    private static int searchSecondSolution(String[] arr, String goal, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;

        if (arr[mid].isEmpty()) {
            mid = getNearestNonEmptyString(arr, first, last, mid);
            if (mid == -1) return -1;
        }

        int comparison = arr[mid].compareTo(goal);
        if (comparison > 0) return searchSecondSolution(arr, goal, first, mid - 1);
        if (comparison < 0) return searchSecondSolution(arr, goal, mid + 1, last);

        return mid;
    }

    private static int getNearestNonEmptyString(String[] arr, int first, int last, int mid) {
        int left = mid - 1;
        int right = mid + 1;

        while (left >= first || right <= last) {
            if (right <= last && !arr[right].isEmpty()) return right;
            if (left >= first && !arr[left].isEmpty()) return left;

            right++;
            left--;
        }

        return -1;
    }
}
