import java.util.Arrays;

/**
 * *** Interview question ***
 * <p>
 * Problem statement: https://youtu.be/CoI4S7z1E1Y
 */
public class RandomlyReOrderArray {

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 7};

        for (int i = 0; i < 10; i++) {
            reorder(array);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void reorder(int[] array) {
        int length = array.length;
        for (int i = length - 1; i >= 0; i--) {
            int j = (int) Math.floor(Math.random() * i);
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
