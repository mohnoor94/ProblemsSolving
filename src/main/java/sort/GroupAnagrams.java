package sort;

import util.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * ***
 * > Two words are anagrams if they contain the same characters but in different orders.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.2)
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"dna", "hello", "and", "hi", "dan", "art", "tra"};
        group(words);
        System.out.println(Arrays.toString(words));
    }

    private static void group(String[] words) {
        HashMapList<String, String> map = new HashMapList<>();

        for (String word : words) map.put(sort(word), word);

        int index = 0;
        while (index < words.length) {
            for (ArrayList<String> group : map.values()) {
                for (String item : group) {
                    words[index++] = item;
                }
            }
        }
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
