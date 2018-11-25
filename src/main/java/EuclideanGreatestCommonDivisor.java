/**
 * Implement a method to calculate GCD - Greatest Common Divisor between 2 numbers.
 * We will use Euclidean algorithm to do that.
 */
public class EuclideanGreatestCommonDivisor {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 3;
        int num3 = 5;

        System.out.println(gcd1(num1, num2));
        System.out.println(gcd1(num1, num3));
        System.out.println();
        System.out.println(gcd2(num1, num2));
        System.out.println(gcd2(num1, num3));
    }

    private static int gcd2(int num1, int num2) {
        return gcdHelper(getSmaller(num1, num2), getBigger(num1, num2));
    }

    private static int gcdHelper(int smaller, int bigger) {
        if (bigger == 0) return smaller;

        return gcdHelper(bigger, smaller % bigger);
    }

    private static int gcd1(int num1, int num2) {
        int bigger = getBigger(num1, num2);
        int smaller = getSmaller(num1, num2);

        while (bigger != 0) {
            int tmp = bigger;
            bigger = smaller % bigger;
            smaller = tmp;
        }

        return smaller;
    }

    private static int getBigger(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    private static int getSmaller(int num1, int num2) {
        return num1 < num2 ? num1 : num2;
    }
}
