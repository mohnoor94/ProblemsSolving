package linkedlist;

import java.util.HashMap;
import java.util.Objects;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to
 * any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node
 * has its value set to the value of its corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in the original list and copied list
 * represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * -
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
 * two nodes x and y in the copied list, x.random --> y.
 * -
 * Return the head of the copied linked list.
 * ***
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CloneDoublyLinkedList {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * -
     * n: length of the list.
     * -
     * ** Solution tested on leetcode. **
     * -
     * TODO: There is a O(1) space solution. Think about it!
     */
    private Node cloneList(Node head) {
        if (head == null) return null;

        final HashMap<Node, Node> correspondingNodes = new HashMap<>();

        Node node = head;
        while (node != null) {
            correspondingNodes.put(node, new Node(node.val));
            node = node.next;
        }

        correspondingNodes.forEach((k, v) -> {
            v.next = correspondingNodes.get(k.next);
            v.random = correspondingNodes.get(k.random);
        });

        return correspondingNodes.get(head);
    }
}
