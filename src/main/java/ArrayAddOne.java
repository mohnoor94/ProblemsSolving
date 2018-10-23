import java.util.Arrays;

/**
 * Problem: Given an array of integers that represents a number, return an array that represents that number added
 * to one.
 * <p>
 * More details: https://youtu.be/uQdy914JRKQ
 * <p>
 * Examples:
 * [1,2,3] -> [1,2,4]
 * [1,2,9] -> [1,3,0]
 * [9,9,9] -> [1,0,0,0]
 */
public class ArrayAddOne {
    public static void main(String[] args) {
        ArrayAddOne addOne = new ArrayAddOne();
        int[] num1 = {1, 2, 3};
        int[] num2 = {1, 2, 9};
        int[] num3 = {9, 9, 9};

        // first solution
        addOne.printSolution(num1, addOne.firstSolution(num1));
        addOne.printSolution(num2, addOne.firstSolution(num2));
        addOne.printSolution(num3, addOne.firstSolution(num3));

        System.out.println("**************");

        // second solution
        addOne.printSolution(num1, addOne.secondSolution(num1));
        addOne.printSolution(num2, addOne.secondSolution(num2));
        addOne.printSolution(num3, addOne.secondSolution(num3));

        System.out.println("**************");

        // third solution
        addOne.printSolution(num1, addOne.thirdSolution(num1));
        addOne.printSolution(num2, addOne.thirdSolution(num2));
        addOne.printSolution(num3, addOne.thirdSolution(num3));
    }

    private int[] firstSolution(int[] digits) {
        int[] copy = getCopy(digits);
        int num = 0;
        int last = copy.length - 1;
        for (int i = last; i >= 0; i--) {
            num += copy[i] * Math.pow(10, last - i);
        }
        return Integer.toString(++num).chars().map(c -> c - '0').toArray();
    }

    private int[] secondSolution(int[] digits) {
        int[] copy = getCopy(digits);
        for (int i = copy.length - 1; i >= 0; i--) {
            if (copy[i] < 9) {
                copy[i]++;
                return copy;
            }
            copy[i] = 0;
        }

        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }

    private int[] thirdSolution(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length];

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum == 10) carry = 1;
            else carry = 0;
            result[i] = sum % 10;
        }

        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }

        return result;
    }

    private int[] getCopy(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    private void printSolution(int[] num, int[] numPlusOne) {
        System.out.println(Arrays.toString(num) + " + 1 ==> " + Arrays.toString(numPlusOne));
    }
}
