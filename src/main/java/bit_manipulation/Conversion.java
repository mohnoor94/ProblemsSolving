package bit_manipulation;

/**
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 * ***
 * Example: 29 (11101) and 15 (01111) --> 2
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 5.6)
 */
public class Conversion {

    public static void main(String[] args) {
        System.out.println(countBitsToFlipFirstSolution(29, 15));
        System.out.println(countBitsToFlipFirstSolution(15, 29));
        System.out.println(countBitsToFlipFirstSolution(10, 10));
        System.out.println(countBitsToFlipFirstSolution(1, 1000));

        System.out.println("***");

        System.out.println(countBitsToFlipSecondSolution(29, 15));
        System.out.println(countBitsToFlipSecondSolution(15, 29));
        System.out.println(countBitsToFlipSecondSolution(10, 10));
        System.out.println(countBitsToFlipSecondSolution(1, 1000));


        System.out.println("***");

        System.out.println(countBitsToFlipThirdSolution(29, 15));
        System.out.println(countBitsToFlipThirdSolution(15, 29));
        System.out.println(countBitsToFlipThirdSolution(10, 10));
        System.out.println(countBitsToFlipThirdSolution(1, 1000));
    }

    private static int countBitsToFlipFirstSolution(int a, int b) {
        if (a == b) return 0;
        int counter = 0;

        while (a != 0 | b != 0) {
            if ((a & 1) != (b & 1)) counter++;
            a >>= 1;
            b >>= 1;
        }

        return counter;
    }

    private static int countBitsToFlipSecondSolution(int a, int b) {
        if (a == b) return 0;
        int counter = 0;
        int xor = a ^ b;

        while (xor != 0) {
            counter += xor & 1; // if LSB (least significant bit) is 1 then the bits are different so we need a flip
            xor >>= 1;
        }

        return counter;
    }

    private static int countBitsToFlipThirdSolution(int a, int b) {
        if (a == b) return 0;
        int counter = 0;
        int xor = a ^ b;

        // count the bits until xor became 0
        while (xor != 0) {
            counter++;
            xor &= xor - 1;
        }

        return counter;
    }

}
