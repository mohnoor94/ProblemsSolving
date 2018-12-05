package bit_manipulation;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M int N such that M starts at bit j and ends at bit i.
 * You can assume that bits j through i have enough space to fit all of M.
 * That is if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * ***
 * Example:
 * * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * * Output:    10001001100
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 5.1)
 */
public class Insertion {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insert1(0b10000000000, 0b10011, 2, 6)));
        System.out.println(Integer.toBinaryString(insert2(0b10000000000, 0b10011, 2, 6)));
        System.out.println();
        System.out.println(Integer.toBinaryString(insert1(0b10000000000, 0b111, 3, 9)));
        System.out.println(Integer.toBinaryString(insert2(0b10000000000, 0b111, 3, 9)));
        System.out.println();
        System.out.println(Integer.toBinaryString(insert1(0b10101010, 0b111, 2, 4)));
        System.out.println(Integer.toBinaryString(insert2(0b10101010, 0b111, 2, 4)));
    }

    private static int insert1(int n, int m, int i, int j) {
        int length = j - i + 1;
        int mask = ~(((1 << length) - 1) << i);
        return n & mask | (m << i);
    }

    private static int insert2(int n, int m, int i, int j) {
        int allOnes = ~0;
        int leftMask = allOnes << (j + 1);
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int clearedN = n & mask;
        int shiftedM = m << i;
        return clearedN | shiftedM;
    }
}
