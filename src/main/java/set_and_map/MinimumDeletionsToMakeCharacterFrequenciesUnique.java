package set_and_map;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * ---
 * Example 1:
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * ---
 * Example 2:
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * ---
 * Example 3:
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 * ---
 * Constraints:
 * * 1 <= s.length <= 105
 * * s contains only lowercase English letters.
 * ***
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    /**
     * Time: O(n)
     * Space: O(n)
     * -
     * n: string size/length.
     * ---
     * Solution tested on leetcode with this result:
     * - Runtime: 44 ms, faster than 26.18% of Java online submissions.
     * - Memory Usage: 39.5 MB, less than 69.16% of Java online submissions.
     */
    public int minDeletions(String s) {
        final HashMap<Character, Integer> frequencies = new HashMap<>();

        for (char c : s.toCharArray()) frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);

        final HashSet<Integer> counts = new HashSet<>();
        int changes= 0;

        for (Integer value : frequencies.values()) {
            while (value > 0 && counts.contains(value)) {
                value--;
                changes++;
            }

            counts.add(value);
        }

        return changes;
    }
}
