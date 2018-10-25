import java.util.Arrays;

/**
 * *** 'Amazon' interview question ***
 * <p>
 * Staircase problem
 * Problem statement and more details: https://youtu.be/5o-kdjv7FD0
 */
public class StaircaseJava {

    public static void main(String[] args) {
        int[] steps1 = {1, 2};
        int[] steps2 = {1, 2, 5};
        int[] steps3 = {1, 3, 5};

        System.out.println(0 + " ==> " + numberOfWays(0));
        System.out.println(1 + " ==> " + numberOfWays(1));
        System.out.println(2 + " ==> " + numberOfWays(2));
        System.out.println(3 + " ==> " + numberOfWays(3));
        System.out.println(4 + " ==> " + numberOfWays(4));
        System.out.println(5 + " ==> " + numberOfWays(5));
        System.out.println(6 + " ==> " + numberOfWays(6));
        System.out.println(7 + " ==> " + numberOfWays(7));
        System.out.println("*******************");
        System.out.println(0 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(0, steps1));
        System.out.println(1 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(1, steps1));
        System.out.println(2 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(2, steps1));
        System.out.println(3 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(3, steps1));
        System.out.println(4 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(4, steps1));
        System.out.println(5 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(5, steps1));
        System.out.println(6 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(6, steps1));
        System.out.println(7 + ", " + Arrays.toString(steps1) + " ==> " + numberOfWays(7, steps1));
        System.out.println("*******************");
        System.out.println(0 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(0, steps2));
        System.out.println(1 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(1, steps2));
        System.out.println(2 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(2, steps2));
        System.out.println(3 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(3, steps2));
        System.out.println(4 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(4, steps2));
        System.out.println(5 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(5, steps2));
        System.out.println(6 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(6, steps2));
        System.out.println(7 + ", " + Arrays.toString(steps2) + " ==> " + numberOfWays(7, steps2));
        System.out.println("*******************");
        System.out.println(0 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(0, steps3));
        System.out.println(1 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(1, steps3));
        System.out.println(2 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(2, steps3));
        System.out.println(3 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(3, steps3));
        System.out.println(4 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(4, steps3));
        System.out.println(5 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(5, steps3));
        System.out.println(6 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(6, steps3));
        System.out.println(7 + ", " + Arrays.toString(steps3) + " ==> " + numberOfWays(7, steps3));
        System.out.println("*******************");
    }

    /**
     * Allowed steps assumed to be either 1 or 2
     */
    private static int numberOfWays(int n) {
        if (n == 0 || n == 1)
            return 1;

        int result, s1, s2;
        result = s1 = s2 = 1;
        for (int i = 2; i <= n; i++) {
            result = s1 + s2;
            s1 = s2;
            s2 = result;
        }

        return result;
    }

    private static int numberOfWays(int n, int[] steps) {
        if (n == 0) return 1;

        var nums = new int[n + 1];
        nums[0] = 1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j : steps) {
                if (i - j >= 0)
                    total += nums[i - j];
            }
            nums[i] = total;
        }

        return nums[n];
    }
}