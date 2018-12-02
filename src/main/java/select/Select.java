package select;

/**
 * Selection algorithm ia an algorithm for finding the k-th smallest/largest number in a list / array.
 * Such a number is called the k-th order statistic.
 * Examples: maximum, minimum, median, 4th largest number, ...
 */
public class Select {

    /**
     * Time:    O(s^2), s: size of the numbers array; average complexity of O(n)
     * Space:   In place
     *
     * @return k-th largest number in an array; k is started at 1.
     */
    public static int qucickSelect(int[] numbers, int k) {
        return QuickSelect.select(numbers, k);
    }
}
