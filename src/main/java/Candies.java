/**
 * *** 'Google' interview question ***
 *
 * Candies Problem
 * <p>
 * Problem Statement: https://www.hackerrank.com/challenges/candies/problem
 */
public class Candies {

    public static void main(String[] args) {
        System.out.println(countCandies(new int[]{1, 2, 2}));
        System.out.println(countCandies(new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1}));
        System.out.println(countCandies(new int[]{5, 4, 1, 2, 3, 10, 13, 11, 3}));
        System.out.println(countCandies(new int[]{5, 10, 10, 10, 5}));
    }

    private static long countCandies(int[] scores) {
        long counter = 0;
        int[] candies = new int[scores.length];
        int cnds = 1;
        candies[0] = cnds;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1])
                candies[i] = ++cnds;
            else {
                cnds = 1;
                candies[i] = cnds;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        for (Integer c : candies)
            counter += c;

        return counter;
    }
}