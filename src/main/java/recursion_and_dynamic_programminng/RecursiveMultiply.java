package recursion_and_dynamic_programminng;

/**
 * Write a recursive function to multiplyIterative two positive integers without using the * operator.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.5)
 */
public class RecursiveMultiply {

    public static void main(String[] args) {
        System.out.println(multiplyIterative(4, 2));
        System.out.println(multiplyRecursive(4, 2));
        System.out.println();

        System.out.println(multiplyIterative(2, 4));
        System.out.println(multiplyRecursive(2, 4));
        System.out.println();

        System.out.println(multiplyIterative(3, 2));
        System.out.println(multiplyRecursive(3, 2));
        System.out.println();

        System.out.println(multiplyIterative(2, 3));
        System.out.println(multiplyRecursive(2, 3));
        System.out.println();

        System.out.println(multiplyIterative(3, 5));
        System.out.println(multiplyRecursive(3, 5));
        System.out.println();

        System.out.println(multiplyIterative(5, 3));
        System.out.println(multiplyRecursive(5, 3));
        System.out.println();

        System.out.println(multiplyIterative(205, 307));
        System.out.println(multiplyRecursive(205, 307));
        System.out.println();
    }

    private static int multiplyRecursive(int num1, int num2) {
        return multiplyRecursive(num1, num2, 0);
    }

    private static int multiplyRecursive(int num1, int num2, int result) {
        if (num1 == 0) return result;

        return multiplyRecursive(num1 >> 1, num2 << 1, ((num1 & 1) == 1) ? result + num2 : result);
    }

    private static int multiplyIterative(int num1, int num2) {
        int even, other;
        boolean bothOdd = false;

        if (num1 % 2 == 0) {
            even = num1;
            other = num2;
        } else if (num2 % 2 == 0) {
            even = num2;
            other = num1;
        } else {
            even = num1 - 1;
            other = num2;
            bothOdd = true;
        }

        int result = 0;
        int factor = 0;
        while (even != 0) {
            if ((even & 1) == 1) {
                result += other << factor;
            }
            even >>= 1;
            factor += 1;
        }

        return bothOdd ? result + other : result;
    }
}
