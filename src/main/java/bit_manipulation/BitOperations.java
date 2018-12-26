package bit_manipulation;

/**
 * @see "Cracking the coding interview, a book by Gayle Mcdowell (6th ed., chapter 5)"
 */
public class BitOperations {

    public static void main(String[] args) {
        System.out.println("getBit(x, 3)");
        printBinaryAndResult(5, getBit(5, 3));
        printBinaryAndResult(10, getBit(10, 3));
        printBinaryAndResult(17, getBit(17, 3));
        System.out.println("\nsetBit(x, 3)");
        printBinaryAndResult(5, setBit(5, 3));
        printBinaryAndResult(10, setBit(10, 3));
        printBinaryAndResult(17, setBit(17, 3));
        System.out.println("\nclearBit(x, 3)");
        printBinaryAndResult(5, clearBit(5, 3));
        printBinaryAndResult(10, clearBit(10, 3));
        printBinaryAndResult(17, clearBit(17, 3));
        System.out.println("\nclearBitsMSBthroughI(x, 3)");
        printBinaryAndResult(5, clearBitsMSBthroughI(5, 3));
        printBinaryAndResult(10, clearBitsMSBthroughI(10, 3));
        printBinaryAndResult(17, clearBitsMSBthroughI(17, 3));
        System.out.println("\nclearBitsIthrough0(x, 3)");
        printBinaryAndResult(5, clearBitsIthrough0(5, 3));
        printBinaryAndResult(10, clearBitsIthrough0(10, 3));
        printBinaryAndResult(17, clearBitsIthrough0(17, 3));
        System.out.println("\nupdateBit(x, 3, true)");
        printBinaryAndResult(5, updateBit(5, 3, true));
        printBinaryAndResult(10, updateBit(10, 3, true));
        printBinaryAndResult(17, updateBit(17, 3, true));
        System.out.println("\nupdateBit(x, 3, false)");
        printBinaryAndResult(5, updateBit(5, 3, false));
        printBinaryAndResult(10, updateBit(10, 3, false));
        printBinaryAndResult(17, updateBit(17, 3, false));
    }

    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        return num & (~(1 << i));
    }

    /**
     * Clear all bits from most significant bit through i (inclusive)
     */
    public static int clearBitsMSBthroughI(int num, int i) {
        return num & ((1 << i) - 1);
    }

    /**
     * Clear all bits frm i through 0 (inclusive)
     */
    public static int clearBitsIthrough0(int num, int i) {
        return num & (-1 << (i + 1));
    }

    public static int updateBit(int num, int i, boolean isBit1) {
        int numWithBitCleared = clearBit(num, i);
        int bit = isBit1 ? 1 : 0;
        return numWithBitCleared | (bit << i);
    }

    private static void printBinaryAndResult(int num, int result) {
        System.out.println(Integer.toBinaryString(num) + " --> " + Integer.toBinaryString(result));
    }

    private static void printBinaryAndResult(int num, boolean result) {
        System.out.println(Integer.toBinaryString(num) + " --> " + (result ? 1 : 0));
    }
}
