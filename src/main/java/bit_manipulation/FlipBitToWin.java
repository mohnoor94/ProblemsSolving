package bit_manipulation;

/**
 * You have an integer and you can exactly flip one bit from 0 to 1.
 * Write a code to find the length of the longest sequence of 1s you could create.
 * ***
 * Example:
 * * Input: 75  (11011101111b)
 * * Output: 8
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 5.3)
 */
public class FlipBitToWin {

    public static void main(String[] args) {
        print(1775);
        print(5);
        print(Integer.MAX_VALUE);
        print(0);
        print(1);
        print(2);
        print(10);
    }

    private static int longestSequence(int num) {
        if (num == 1) return 1;
        if (~num == 0) return 32;   // could be removed

        int zeroLocation = 1;
        int counter = 1;
        int longest = 1;

        while (num != 0) {
            if ((num & 1) == 0) {
                int oldZeroLocation = zeroLocation;
                zeroLocation = counter;
                counter = counter - oldZeroLocation;
            }
            counter++;
            if (counter > longest) longest = counter;
            num >>= 1;
        }

        return longest;
    }

    private static void print(int num) {
        System.out.println(num + " (" + Integer.toBinaryString(num) + ") --> " + longestSequence(num));
    }
}
