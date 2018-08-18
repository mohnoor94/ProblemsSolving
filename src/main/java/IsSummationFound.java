import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: Given an array/ list of numbers and a summation.
 * Find if the array/list has any 2 numbers that can be added together to introduce the summation value.
 * Example: list(1,2,3), summation(5) => True (2 + 3 = 5)
 * Example: list(1,2,3), summation(10) => False (There are no 2 numbers can yield a summation of 10)
 * Example: list(1,2,3), summation(6) => False (There are no 2 numbers can yield a summation of 6)
 */
public class IsSummationFound {

    public static void main(String[] args) {
        System.out.println(isSummationFound(new int[]{1, 2, 3}, 5));
        System.out.println(isSummationFound(new int[]{1, 2, 3}, 10));
        System.out.println(isSummationFound(new int[]{1, 2, 3}, 6));
        System.out.println(isSummationFound(new int[]{1, 2, 3}, 100));
        System.out.println(isSummationFound(new int[]{1, 2, 3, 7, 9, -10, 26, -40, 138, 140}, 100));
    }

    private static boolean isSummationFound(int[] numbers, int summation) {
        return isSummationFound(IntStream.of(numbers).boxed().collect(Collectors.toList()), summation);
    }

    private static boolean isSummationFound(List<Integer> numbers, int summation) {
        var counter = new HashMap<Integer, Integer>();

        numbers.forEach(num -> counter.compute(num, (value, count) -> count == null ? 1 : count + 1));

        for (Integer num : numbers) {
            if (((num * 2 == summation) && counter.get(num) >= 2)
                    || (num != summation - num && counter.containsKey(num) && counter.containsKey(summation - num)))
                return true;
        }

        return false;
    }
}
