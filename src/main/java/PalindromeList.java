import datastructure.Node;
import util.Utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a function to check if a linked list is a palindrome.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.6)
 */
public class PalindromeList {

    public static void main(String[] args) {
        System.out.println(isPalindromeByReverseAndCompare(getPalindromeNodeWithOddLength()));
        System.out.println(isPalindromeByReverseAndCompare(getPalindromeNodeWithEvenLength()));
        System.out.println(isPalindromeByReverseAndCompare(getUnPalindromeNode()));

        System.out.println();

        System.out.println(isPalindromeUsingStack(getPalindromeNodeWithOddLength()));
        System.out.println(isPalindromeUsingStack(getPalindromeNodeWithEvenLength()));
        System.out.println(isPalindromeUsingStack(getUnPalindromeNode()));

        System.out.println();

        System.out.println(isPalindromeUsingRecursion(getPalindromeNodeWithOddLength()));
        System.out.println(isPalindromeUsingRecursion(getPalindromeNodeWithEvenLength()));
        System.out.println(isPalindromeUsingRecursion(getUnPalindromeNode()));
    }

    private static boolean isPalindromeByReverseAndCompare(Node node) {
        if (node == null) return true;

        Node reversed = reverseAndClone(node);

        return isEqual(node, reversed);
    }

    private static Node reverseAndClone(Node node) {
        Node head = node;
        Node reversed = new Node(head.data);
        head = head.next;

        while (head != null) {
            reversed = Utils.insertBefore(reversed, head.data);
            head = head.next;
        }

        return reversed;
    }

    private static boolean isEqual(Node node, Node reversed) {
        while (node != null) {
            if (node.data != reversed.data) return false;
            node = node.next;
            reversed = reversed.next;
        }

        return true;
    }

    private static boolean isPalindromeUsingStack(Node node) {
        Deque<Integer> stack = new LinkedList<>();

        // since we have no idea about the length of the list
        // we sed the 2 runners approach
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && !stack.isEmpty()) {
            if (stack.pop() != slow.data) return false;
            slow = slow.next;
        }

        return true;
    }

    private static boolean isPalindromeUsingRecursion(Node node) {
        int length = Utils.getLength(node);

        PalindromeResult result = isPalindromeRecurse(node, length);

        return result.result;
    }

    private static PalindromeResult isPalindromeRecurse(Node node, int length) {
        if (node == null || length <= 0) return new PalindromeResult(node, true);
        if (length == 1) return new PalindromeResult(node.next, true);

        PalindromeResult result = isPalindromeRecurse(node.next, length - 2);

        if (!result.result || result.node == null) return result;

        result.result = node.data == result.node.data;
        result.node = result.node.next;

        return result;
    }

    private static Node getPalindromeNodeWithOddLength() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        return a;
    }

    private static Node getPalindromeNodeWithEvenLength() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        return a;
    }

    private static Node getUnPalindromeNode() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        return a;
    }
}

class PalindromeResult {
    Node node;
    boolean result;

    public PalindromeResult(Node node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
