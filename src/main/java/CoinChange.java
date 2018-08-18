import java.util.HashMap;

/**
 * The Coin Change Problem
 * Problem Statement: https://www.hackerrank.com/challenges/coin-change/problem
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(getWays(4, new long[]{1L, 2L, 3L}));
        System.out.println(getWays(10, new long[]{2L, 5L, 3L, 6L}));
    }

    private static long getWays(long amount, long[] coins) {
        return getWays(amount, coins, 0, new HashMap<>());
    }

    private static long getWays(long amount, long[] coins, int index, HashMap<String, Long> cache) {
        if (amount == 0) return 1;
        if (index == coins.length) return 0;

        var cacheKey = amount + "@" + index;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        var numberOfWays = 0L;
        var currentAmount = 0;
        while (currentAmount <= amount) {
            numberOfWays += getWays(amount - currentAmount, coins, index + 1, cache);
            currentAmount += coins[index];
        }

        cache.put(cacheKey, numberOfWays);

        return numberOfWays;
    }
}
