/**
 * Implement a method to calculate factorial of n.
 */
public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial1(n));
        System.out.println(factorial2(n));
        System.out.println(factorial3(n));
    }

    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    private static long factorial3(int n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(int accumulator, int n) {
        if (n == 1) return accumulator;

        return factorialHelper(n * accumulator, n - 1);
    }

    /**
     * Time:    O(n)
     * Space:   O(n);   to store n in stack
     */
    private static long factorial2(int n) {
        if (n == 1) return n;

        return n * factorial2(n - 1);
    }

    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    private static long factorial1(int n) {
        long result = 1;

        while (n > 1) {
            result *= n;
            n--;
        }

        return result;
    }
}
