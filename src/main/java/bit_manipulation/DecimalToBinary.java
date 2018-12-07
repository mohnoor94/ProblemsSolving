package bit_manipulation;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with ar most 32 characters, print 'ERROR'.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 5.2)
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(0.72));
        System.out.println(decimalToBinary(0.8125));
        System.out.println(decimalToBinary(0.5));
    }

    private static String decimalToBinary(double num) {
        if (num > 1 || num < 0) return "ERROR";

        StringBuilder result = new StringBuilder(".");
        while (num > 0) {
            if (result.length() > 32) return "ERROR";

            num *= 2;
            if (num >= 1) {
                result.append(1);
                num -= 1;
            } else {
                result.append(0);
            }

        }
        return result.toString();
    }
}