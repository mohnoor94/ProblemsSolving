package array;

/**
 * *** 'Google' interview question ***
 * ***
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs
 * come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
 * ***
 * Do this in linear time and in-place.
 * ***
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become
 * ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 * ***
 */
public class RGBsArray {

    /**
     * Time: O(n)
     * Space: O(1)
     * -
     * n: input size
     */
    private void sortColors(char[] colors) {
        int r = 0;
        int g = 0;
        int b = 0;

        for (char color : colors) {
            if (color == 'R') r++;
            else if (color == 'G') g++;
            else if (color == 'B') b++;
        }

        for (int i = 0; i < r; i++) colors[i] = 'R';
        for (int i = r; i < g + r; i++) colors[i] = 'G';
        for (int i = g + r; i < g + r + b; i++) colors[i] = 'B';
    }

    // Very light testing
    public static void main(String[] args) {
        final char[] colors = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        System.out.println(colors);
        new RGBsArray().sortColors(colors);
        System.out.println(colors);
    }
}
