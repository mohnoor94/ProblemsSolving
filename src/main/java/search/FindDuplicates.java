package search;

/**
 * You have an array with all numbers from 1 to N, where N is at most 32000.
 * The array may have duplicate entries and you do not know what N is.
 * With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.8)
 */
public class FindDuplicates {

    public static void main(String[] args) {
        printAllDuplicates2(new int[]{1, 3, 6, 2, 4, 6, 1, 55, 9, 1200, 4});
        System.out.println("***");
        printAllDuplicates2(new int[]{1, 8, 9, 12, 26});
        System.out.println("***");
        printAllDuplicates2(new int[]{1, 8, 9, 12, 26, 26, 12, 9, 8, 1});
        System.out.println("***");
    }

    /**
     * This solution will use 32000 bits = 4000 bytes <= 4 kilobytes
     */
    private static void printAllDuplicates2(int[] arr) {
        MyBitSet bitSet = new MyBitSet(32000);

        for (int n : arr) {
            int n0 = n - 1; // bitSet starts at 0
            if (bitSet.get(n0)) System.out.println(n);
            else bitSet.set(n0);
        }
    }

    /**
     * I read about the size of allocated memory to `boolean` datatype in Java, and it's, surprisingly, not a bit!
     * The official docs says: 'This bitSet type represents one bit of information, but its "size" isn't something that's
     * precisely defined.' The actual size depends on the JVM implementation, and there are some resources that said
     * that SUN JVM allocate a BYTE for each boolean!
     *
     * @see https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
     * ***
     * Assumes that each boolean takes 1 byte, our solution will allocate 32000 bytes = 32 kilobytes.
     * So that this solution will be INVALID!
     */
    private static void printAllDuplicates1(int[] arr) {
        boolean[] bv = new boolean[32000];

        for (int num : arr) {
            if (bv[num]) System.out.println(num);
            else bv[num] = true;
        }
    }
}

class MyBitSet {
    private int[] bitSet;

    MyBitSet(int size) {
        bitSet = new int[size >> 5 + 1]; // 1 int = 4 bytes = 32 bits
    }

    void set(int pos) {
        int wordNumber = pos >> 5;  // n / 32
        int bitNumber = pos & 0x1F; // n % 32
        bitSet[wordNumber] |= 1 << bitNumber;
    }

    boolean get(int pos) {
        int wordNumber = pos >> 5;  // n / 32
        int bitNumber = pos & 0x1F; // n % 32
        return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
    }
}
