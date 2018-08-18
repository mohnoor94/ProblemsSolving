/**
 * Two Strings Problem
 *
 * Problem Statement: https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
        System.out.println(twoStrings("hi", "hell"));
    }

    private static String twoStrings(String s1, String s2) {
        var a1 = new boolean[26];
        var a2 = new boolean[26];

        for (char c : s1.toCharArray())
            a1[c - 97] = true;

        for (char c : s2.toCharArray())
            a2[c - 97] = true;

        for (int i = 0; i < 26; i++)
            if (a1[i] && a2[i])
                return "YES";

        return "NO";
    }


}