import util.Node;

import java.util.HashSet;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * ***
 * Circular linked list is a (Corrupted) linked list in which a node's next pointer points to an earlier node, so as
 * to make a loop in the linked list.
 * ***
 * Example:
 * * Input:     A -> B -> C -> D -> E -> C [the same C as earlier]
 * * Output:    C
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.8)
 */
public class LinkedListLoopDetection {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(getLoopNode(a));
        System.out.println(getLoopNodeUsingSet(a));

        e.next = c;
        System.out.println();

        System.out.println(getLoopNode(a));
        System.out.println(getLoopNodeUsingSet(a));
    }

    /**
     * Time:    O(n);   n: list length
     * Space:   O(1)
     */
    private static Node getLoopNode(Node node) {
        if (node == null) return null;

        Node slow = node;
        Node fast = node;

        // keep going, stop when we reach any collision node
        // this node might not be the first one
        // the point is LOOP_SIZE - k steps into the list; while k is the 'non-looped' part of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // check if there is no loop at all
        if (fast == null || fast.next == null) return null;

        // move slow to head. Keep fast at the meeting node
        // each are k steps from the loop start
        // if the move at the same pace, they must meet at loop start.
        slow = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    /**
     * Time:    O(n);   n: list length
     * Space:   O(n)
     */
    private static Node getLoopNodeUsingSet(Node node) {
        if (node == null) return null;

        HashSet<Node> nodes = new HashSet<>();

        while (node != null) {
            if (nodes.contains(node)) return node;
            nodes.add(node);
            node = node.next;
        }

        return null;
    }
}