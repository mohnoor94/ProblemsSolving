/**
 * Candies Problem
 *
 * Problem Statement: https://www.hackerrank.com/challenges/candies/problem
 */
public class Candies {

    public static void main(String[] args) {
        System.out.println(getMinCandies(3, new int[]{1, 2, 2}));
        System.out.println(getMinCandies(10, new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1}));
    }

    private static long getMinCandies(int n, int[] ratings) {
        int previous;
        int current;
        int[] candies = new int[n];
        long c; // Number of Candies

        previous = ratings[0];

        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            current = ratings[i];
            if (current > previous) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
            previous = current;
        }

        // Revisit and count candies
        previous = ratings[n - 1];
        c = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            current = ratings[i];
            if (current > previous && candies[i + 1] >= candies[i]) {
                candies[i] = candies[i + 1] + 1;
            }
            c += candies[i];
            previous = current;
        }
        return c;
    }
}