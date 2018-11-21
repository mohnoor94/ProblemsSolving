import util.Node;
import util.Utils;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return tge intersection node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the Kth node of the first linked list is the exact same node (by reference) as the Jth node of the
 * second linked list, then they are intersecting.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.7)
 */
public class TwoListsIntersection {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        f.next = c;

        g.next = h;
        h.next = i;

        a.print();
        f.print();
        g.print();

        System.out.println();

        System.out.println(getIntersectionNode(a, f));
        System.out.println(getIntersectionNode(a, g));
        System.out.println(getIntersectionNode(f, g));

        System.out.println();

        System.out.println(getIntersectionNodeUsingStacks(a, f));
        System.out.println(getIntersectionNodeUsingStacks(a, g));
        System.out.println(getIntersectionNodeUsingStacks(f, g));

        System.out.println();

        System.out.println(getIntersectionNodeUsingSet(a, f));
        System.out.println(getIntersectionNodeUsingSet(a, g));
        System.out.println(getIntersectionNodeUsingSet(f, g));
    }

    /**
     * Time:    O(A+B); A,B: lengths of first and second list
     * Space:   O(1)
     */
    private static Node getIntersectionNode(Node first, Node second) {
        int len1 = Utils.getLength(first);
        int len2 = Utils.getLength(second);

        while (len1 > len2 && first != null) {
            first = first.next;
            len1--;
        }
        while (len2 > len1 && second != null) {
            second = second.next;
            len2--;
        }

        while (first != null && second != null && first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    /**
     * Time:    O(A+B); A,B: lengths of first and second list
     * Space:   O(max(A,B))
     */
    private static Node getIntersectionNodeUsingSet(Node first, Node second) {
        Set<Node> nodes = new HashSet<>();

        while (first != null) {
            nodes.add(first);
            first = first.next;
        }

        while (second != null) {
            if (nodes.contains(second)) return second;
            second = second.next;
        }

        return null;
    }

    /**
     * Time:    O(A+B); A,B: lengths of first and second list
     * Space:   O(A+B)
     */
    private static Node getIntersectionNodeUsingStacks(Node first, Node second) {
        Deque<Node> firstStack = new LinkedList<>();
        Deque<Node> secondStack = new LinkedList<>();

        while (first != null) {
            firstStack.push(first);
            first = first.next;
        }

        while (second != null) {
            secondStack.push(second);
            second = second.next;
        }

        if (firstStack.peek() != secondStack.peek()) return null;

        Node intersection = null;

        while ((first = firstStack.pop()) == secondStack.pop()) {
            intersection = first;
        }

        return intersection;
    }
}