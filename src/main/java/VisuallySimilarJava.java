import java.util.HashMap;
import java.util.Map;

/**
 * Recognize visually similar sentences
 * Visually similar characters are those look similar
 * Visually similar characters to consider:
 * O 0 Q
 * I 1
 * S 5
 * The input are assumed to contain capital letters only.
 */
public class VisuallySimilarJava {

    private static Map<Character, Character> replacements = new HashMap<>();

    static {
        replacements.put('Q', 'O');
        replacements.put('0', 'O');
        replacements.put('1', 'I');
        replacements.put('S', '5');
    }

    public static void main(String[] args) {
        System.out.println(isVisuallySimilar("HELLO", "HELLQ"));
        System.out.println(isVisuallySimilar("HELLO", "HELLQ World"));
        System.out.println(isVisuallySimilar("HI FIVE", "H1 F1VE"));
    }

    private static boolean isVisuallySimilar(String firstSentence, String secondSentence) {
        for (Map.Entry<Character, Character> entry : replacements.entrySet()) {
            firstSentence = firstSentence.replaceAll(entry.getKey().toString(), entry.getValue().toString());
            secondSentence = secondSentence.replaceAll(entry.getKey().toString(), entry.getValue().toString());
        }
        return firstSentence.equals(secondSentence);
    }
}
