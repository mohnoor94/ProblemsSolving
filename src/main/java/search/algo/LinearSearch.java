package search.algo;

public class LinearSearch {

    public static void main(String[] args) {
        int[] ints = {1, 5, 9, 2, 3, 7, 4};

        System.out.println(linearSearch(ints, 3));
        System.out.println(linearSearch(ints, 8));
    }

    /**
     * Time:    O(n)
     * Space:   O(1); no additional space required
     * ***
     * If the array is not sorted, we cannot do better than O(n) search time.
     */
    static int linearSearch(int[] array, int goal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == goal) return i;
        }
        return -1;
    }
}
