package datastructure.stack;

import datastructure.stack.implementation.GenericStack;

/**
 * Design a stack in which, in addition to push and pop, has a function 'min' which return the minimum element.
 * * All operations should take O(1) time.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 3.2)
 */
public class StackMin {

    public static void main(String[] args) {
        testFirstSolution();
        testSecondSolution();
    }

    private static void testFirstSolution() {
        StackMinFirstSolution stack1 = new StackMinFirstSolution();
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
        stack1.push(5);
        System.out.println(stack1.peek());
        System.out.println(stack1.getMinimum());
        System.out.println();
        stack1.push(10);
        System.out.println(stack1.peek());
        System.out.println(stack1.getMinimum());
        System.out.println();
        stack1.push(3);
        System.out.println(stack1.peek());
        System.out.println(stack1.getMinimum());
        System.out.println();
        stack1.push(-5);
        System.out.println(stack1.peek());
        System.out.println(stack1.getMinimum());
        System.out.println();
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinimum());
        System.out.println();
    }

    private static void testSecondSolution() {
        StackMinSecondSolution stack2 = new StackMinSecondSolution();
        System.out.println(stack2.peek());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
        stack2.push(5);
        System.out.println(stack2.peek());
        System.out.println(stack2.getMinimum());
        System.out.println();
        stack2.push(10);
        System.out.println(stack2.peek());
        System.out.println(stack2.getMinimum());
        System.out.println();
        stack2.push(3);
        System.out.println(stack2.peek());
        System.out.println(stack2.getMinimum());
        System.out.println();
        stack2.push(-5);
        System.out.println(stack2.peek());
        System.out.println(stack2.getMinimum());
        System.out.println();
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
        System.out.println(stack2.pop());
        System.out.println(stack2.getMinimum());
        System.out.println();
    }
}

class StackMinFirstSolution extends GenericStack<Integer> {
    private GenericStack<Integer> min = new GenericStack<>();

    @Override
    public Integer pop() {
        if (peek() == null) return null;
        if (peek().equals(min.peek())) min.pop();
        return super.pop();
    }

    @Override
    public void push(Integer item) {
        if (min.peek() == null || item < min.peek())
            min.push(item);
        super.push(item);
    }

    Integer getMinimum() {
        return min.peek();
    }
}

class StackMinSecondSolution {
    class NodePlus {
        int data;
        NodePlus next;
        int min;

        NodePlus(int data) {
            this.data = data;
        }
    }

    private NodePlus top;

    Integer peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    Integer pop() {
        if (isEmpty()) return null;

        int data = top.data;
        top = top.next;

        return data;
    }

    void push(int item) {
        NodePlus newNode = new NodePlus(item);
        newNode.min = top == null ? item : Math.min(item, top.data);
        newNode.next = top;
        top = newNode;
    }

    Integer getMinimum() {
        if (top == null) return null;

        return top.min;
    }

    public boolean isEmpty() {
        return top == null;
    }
}