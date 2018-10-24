import java.util.HashMap;
import java.util.Map;

/**
 * Ransom Note Problem
 * <p>
 * Problem statement: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

    public static void main(String[] args) {
        checkMagazine("give me one grand today night".split("\\s"), "give one grand today".split("\\s"));
        checkMagazine("two times three is not four".split("\\s"), "two times two is four".split("\\s"));
        checkMagazine("ive got a lovely bunch of coconuts".split("\\s"), "ive got some coconuts".split("\\s"));
    }

    private static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> mag = new HashMap<>();
        for (String w : magazine) {
            if (mag.containsKey(w)) {
                mag.put(w, mag.get(w) + 1);
            } else {
                mag.put(w, 1);
            }
        }

        for (String w : note) {
            if (!mag.containsKey(w) || mag.get(w) < 1) {
                System.out.println("No");
                return;
            } else {
                mag.put(w, mag.get(w) - 1);
            }
        }
        System.out.println("Yes");
    }
}
