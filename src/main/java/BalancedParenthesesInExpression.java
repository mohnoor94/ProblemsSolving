import java.util.Stack;

/**
 * Problem: Check if the the parentheses in any given string are correctly opened and closed.
 * Examples are in the 'main' methods
 */
public class BalancedParenthesesInExpression {

    private static final char[][] TOKENS = {{'{', '}'}, {'(', ')'}, {'[', ']'}};

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