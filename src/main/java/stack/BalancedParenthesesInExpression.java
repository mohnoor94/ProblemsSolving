package stack;

import java.util.*;

/**
 * Problem: Check if the the parentheses in any given string are correctly opened and closed.
 * Examples are in the 'main' methods
 */
public class BalancedParenthesesInExpression {

    /**
     * A newer neat solution with same complexity.
     * <p>
     * Time: O(n)
     * Space: O(n)
     * <p>
     * n: string length.
     */
    public static boolean isBalanced2(String code) {
        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Deque<Character> openersStack = new ArrayDeque<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();

                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openersStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{([])}")); // true
        System.out.println(isBalanced("{([])")); // false
        System.out.println(isBalanced("{([[)}")); // false
        System.out.println(isBalanced("{(]])}")); // false
        System.out.println(isBalanced("()")); // true
        System.out.println(isBalanced("(hello)")); // true
        System.out.println(isBalanced("{.(,[hi],).}")); // true
        System.out.println(isBalanced("{.(},[hi],{).}")); // false
    }

    private static final char[][] TOKENS = {{'{', '}'}, {'(', ')'}, {'[', ']'}};

    /**
     * Time: O(n)
     * Space: O(n)
     * <p>
     * n: string length.
     */
    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray())
            if (notTerm(c)) continue;
            else if (isOpenTerm(c)) stack.push(c);
            else if (stack.isEmpty() || !matches(stack.pop(), c)) return false;
        return stack.isEmpty();
    }

    private static boolean notTerm(char c) {
        for (char[] token : TOKENS) if (token[0] == c || token[1] == c) return false;
        return true;
    }

    private static boolean isOpenTerm(char term) {
        for (char[] token : TOKENS) if (token[0] == term) return true;
        return false;
    }

    private static boolean matches(char openTerm, char closeTerm) {
        for (char[] token : TOKENS) if (token[0] == openTerm && token[1] == closeTerm) return true;
        return false;
    }
}