package search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 7, 9, 12, 15};

        System.out.println(binarySearch(ints, 3));
        System.out.println(binarySearch(ints, 8));
        System.out.println(binarySearch(ints, 9));
        System.out.println(binarySearch(ints, 15));
        System.out.println(binarySearch(ints, 1));

        System.out.println();

        System.out.println(IterativeBinarySearch(ints, 3));
        System.out.println(IterativeBinarySearch(ints, 8));
        System.out.println(IterativeBinarySearch(ints, 9));
        System.out.println(IterativeBinarySearch(ints, 15));
        System.out.println(IterativeBinarySearch(ints, 1));
    }

    /**
     * Time:    O(log(n));  n: size of the array
     * Space:   O(1)
     */
    static int binarySearch(int[] array, int goal) {
        return binarySearchHelper(array, 0, array.length - 1, goal);
    }

    private static int binarySearchHelper(int[] array, int startIndex, int endIndex, int goal) {
        if (startIndex > endIndex) return -1;

        int middleIndex = (startIndex + endIndex) / 2;

        if (array[middleIndex] == goal) return middleIndex;
        if (array[middleIndex] < goal) return binarySearchHelper(array, middleIndex + 1, endIndex, goal);
        return binarySearchHelper(array, startIndex, middleIndex - 1, goal);
    }

    /**
     * Time:    O(log(n));  n: size of the array
     * Space:   O(1)
     */
    private static int IterativeBinarySearch(int[] array, int goal) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (endIndex >= startIndex) {
            int middleIndex = (endIndex + startIndex) / 2;

            if (array[middleIndex] == goal) return middleIndex;
            else if (array[middleIndex] < goal) startIndex = middleIndex + 1;
            else endIndex = middleIndex - 1;
        }

        return -1;
    }
}
