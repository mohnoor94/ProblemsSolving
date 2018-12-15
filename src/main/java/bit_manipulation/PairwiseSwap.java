package bit_manipulation;

/**
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 5.7)
 */
public class PairwiseSwap {

    public static void main(String[] args) {
        printSolution(5);
        printSolution(-5);
        printSolution(1023);
        printSolution(6987);
    }

    private static int pairwiseSwap(int a) {
        // a & 0xAAAAAAAA --> get even bits of a
        // (a & 0xAAAAAAAA) >>> 1) --> swap right the even bits to take place of odd bits; fill sign bit with zero
        // a & 0x55555555 --> get the odd bits of a
        // (a & 0x55555555) << 1) --> swap left the odd bits to take place of even bits
        // (((a & 0xAAAAAAAA) >>> 1) | ((a & 0x55555555) << 1)) --> merge 2 numbers to get the final results
        return (((a & 0xAAAAAAAA) >>> 1) | ((a & 0x55555555) << 1));
    }

    private static void printSolution(int a) {
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(pairwiseSwap(a)));
        System.out.println();
    }
}
