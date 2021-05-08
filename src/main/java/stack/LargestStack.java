package stack;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;

import static junit.framework.TestCase.assertEquals;

/**
 * You want to be able to access the largest element in a stack.
 * Use the built-in Stack class to implement a new class MaxStack with a method getMax() that returns the largest
 * element in the stack. getMax() should not remove the item.
 * Your stacks will contain only integers.
 * ***
 * https://www.interviewcake.com/question/largest-stack?course=fc1&section=queues-stacks
 */
public class LargestStack {

    /**
     * Time: O(1) for all operations: push(), pop(), and getMax().
     * Space: O(m).
     *
     * m: the number of operations performed on the stack.
     */
    @SuppressWarnings("ConstantConditions")
    public static class MaxStack {
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final Deque<Integer> maxes = new ArrayDeque<>();

        public void push(int item) {
            stack.push(item);
            if (maxes.isEmpty() || item >= maxes.peek()) maxes.push(item);
        }

        public int pop() {
            if (stack.peek().equals(maxes.peek())) maxes.pop();
            return stack.pop();
        }

        public int getMax() {
            return maxes.peek();
        }
    }


    // tests
    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LargestStack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
