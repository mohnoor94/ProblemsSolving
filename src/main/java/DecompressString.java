import java.util.ArrayList;

/**
 * *** 'Google' interview question ***
 * ***
 * Given a compressed string in which a number followed by [] indicate how many times those characters occur,
 * decompress the string.
 * Eg. : a3[b2[c1[d]]]e will be decompressed as abcdcdbcdcdbcdcde.
 * Assume the string is well formed and number will always be followed by a [].
 * ***
 * Problem statement: https://leetcode.com/discuss/interview-experience/124626/Google-onsite-interview-questions
 */
public class DecompressString {

    public static void main(String[] args) {
        System.out.println(decompress("a3[b2[c1[d]]]e"));
        System.out.println(decompress("3[b2[c1[d]]]e"));
        System.out.println(decompress("a3[b2[c1[d]]]"));
    }

    private static String decompress(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (isChar(c)) {
                list.add(c);
                i++;
            } else if (isNumber(c)) {
                String subString = getSubString(s, i + 1);
                decompress(Character.getNumericValue(c), subString, list);
                i += subString.length();
            } else {
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    private static String getSubString(String s, int start) {
        int counter = 0;
        int i = start;
        while (i < s.length()) {
            if (s.charAt(i) == '[') counter++;
            else if (s.charAt(i) == ']') counter--;
            if (counter == 0) return s.substring(start, i + 1);
            i++;
        }

        return "";
    }

    private static void decompress(int n, String s, ArrayList<Character> result) {
        if (s.length() == 0) return;

        char letter = s.charAt(1);
        if (!isNumber(s.charAt(2))) {
            result.add(letter);
            return;
        }

        int c = Character.getNumericValue(s.charAt(2));
        String remaining = s.substring(3);
        for (int i = 0; i < n; i++) {
            result.add(letter);
            decompress(c, remaining, result);
        }
    }

    private static boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
