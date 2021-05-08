package stack;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * I like parenthesis (a lot).
 * "Sometimes (when I nest them (my parenthesis) too much (like this (and this))) they get confusing."
 * Write a method that, given a sentence like the one above, along with the position of an opening parenthesis,
 * finds the corresponding closing parenthesis.
 * Example: if the example string above is input with the number 10 (position of the first parenthesis),
 * the output should be 79 (position of the last parenthesis).
 * ***
 * https://www.interviewcake.com/question/java/matching-parens?course=fc1&section=queues-stacks
 * ---
 * The trick to many "parsing" questions like this is using a stack to track which brackets/phrases/etc are "open"
 * as you go.
 * So next time you get a parsing question, one of your first thoughts should be "use a stack!"
 * In this problem, we can realize our stack would only hold '(' characters. So instead of storing each of those
 * characters in a stack, we can store the number of items our stack would be holding.
 * ---
 * That gets us from O(n) space to O(1) space.
 * It's pretty cool when you can replace a whole data structure with a single integer :)
 */
public class ParenthesisMatching {

    /**
     * Time: O(n)
     * Space: O(1)
     *
     * n: input size
     */
    public static int getClosingParen(String sentence, int openingParenIndex) {
        int neededClosers = 1;

        char[] charArray = sentence.toCharArray();
        for (int i = openingParenIndex + 1; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') neededClosers++;
            else if (c == ')') neededClosers--;

            if (neededClosers == 0) return i;
        }
        throw new IllegalArgumentException("No closing parenthesis :(");
    }

    // tests
    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParenthesisMatching.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}