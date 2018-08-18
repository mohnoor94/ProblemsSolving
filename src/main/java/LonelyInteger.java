import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Lonely Integer
 * <p>
 * Problem Statement: https://www.hackerrank.com/challenges/lonely-integer/problem
 */
public class LonelyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyInteger(new int[]{1, 2, 3, 6, 5, 6, 5, 2, 1}));
    }

    private static int lonelyInteger(int[] a) {
        var map = new HashMap<Integer, Integer>();
        for (int i : a) {
            if (map.containsKey(i))
                map.merge(i, map.get(i), (x, y) -> x + y);
            else
                map.put(i, 1);
        }

        AtomicInteger value = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v == 1) value.set(k);
        });

        return value.get();
    }
}
