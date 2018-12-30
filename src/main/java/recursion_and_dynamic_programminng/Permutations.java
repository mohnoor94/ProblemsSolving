package recursion_and_dynamic_programminng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 1- Permutations without dups: Write a method to compute all permutations of a string of unique characters.
 * ***
 * 2- Permutations with dups: Write a method to compute all permutations of a string whose characters are not
 * necessarily unique. The list of permutations should not have duplicates.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.7 && q 8.8)
 */
@SuppressWarnings("Duplicates")
public class Permutations {

    public static void main(String[] args) {
        System.out.println(getPermutationsWithoutDups("a"));
        System.out.println(getPermutationsWithoutDups("ab"));
        System.out.println(getPermutationsWithoutDups("abc"));
        System.out.println(getPermutationsWithoutDups("abcd"));
        System.out.println(getPermutationsWithoutDups("abcde"));

        System.out.println();

        System.out.println(getPermutationsWithDups1("abab"));
        System.out.println(getPermutationsWithDups1("abcba"));
        System.out.println(getPermutationsWithDups1("aaabaaaaaabb"));
    }

    private static List<String> getPermutationsWithoutDups(String word) {
        if (word == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (word.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = word.charAt(0);
        String reminder = word.substring(1);
        List<String> words = getPermutationsWithoutDups(reminder);

        for (String w : words) {
            for (int i = 0; i <= w.length(); i++) {
                permutations.add(insertCharAt(w, first, i));
            }
        }

        return permutations;
    }

    private static List<String> getPermutationsWithDups1(String word) {
        return getPermutationsWithDupsHelper(word, new HashSet<>());
    }

    private static List<String> getPermutationsWithDupsHelper(String word, HashSet<String> memo) {
        if (word == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (word.length() == 1) {
            permutations.add(word);
            return permutations;
        }

        char first = word.charAt(0);
        String reminder = word.substring(1);
        List<String> words = getPermutationsWithDupsHelper(reminder, memo);

        for (String w : words) {
            for (int i = 0; i <= w.length(); i++) {
                String s = insertCharAt(w, first, i);
                if (!memo.contains(s)) {
                    permutations.add(s);
                    memo.add(s);
                }
            }
        }

        return permutations;
    }

    private static String insertCharAt(String word, char character, int index) {
        return word.substring(0, index) + character + word.substring(index);
    }
}