/**
 * Implement a method to perform a basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * if the 'compressed' string would not be smaller than the original string, your method should return the
 * original string.
 * You can assume that the string has only lowercase letters (a-z).
 * <p>
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.6)
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("var"));
        System.out.println(compressString("varrrrrrrrrr"));
    }

    private static String compressString(String string) {
        int counter = 0;
        StringBuilder compressed = new StringBuilder();

        int length = string.length();
        for (int i = 0; i < length; i++) {
            counter++;
            if (i + 1 >= length || string.charAt(i + 1) != string.charAt(i)) {
                compressed.append(string.charAt(i));
                compressed.append(counter);
                counter = 0;
            }
        }

        return compressed.length() < length ? compressed.toString() : string;
    }
}
