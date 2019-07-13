package datastructure.stack;

import datastructure.stack.implementation.GenericStack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as
 * an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 * ***
 * Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 3.5)
 */
public class SortedStack {

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        stack.print();
        sortStack(stack).print();
    }

    /**
     * Time:    O(N^2); N: size of stack
     * Space:   O(N)
     */
    private static GenericStack<Integer> sortStack(GenericStack<Integer> stack) {
        GenericStack<Integer> helper = new GenericStack<>();

        while (!stack.isEmpty()) {
            int tmp = stack.pop();

            while (!helper.isEmpty() && helper.peek() > tmp) {
                stack.push(helper.pop());
            }

            helper.push(tmp);
        }

        copyStack(helper, stack);

        return stack;
    }

    private static void copyStack(GenericStack<Integer> from, GenericStack<Integer> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}