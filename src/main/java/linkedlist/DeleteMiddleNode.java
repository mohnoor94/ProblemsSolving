package linkedlist;

import node.implementation.Node;
import linkedlist.implementation.SinglyLinkedList;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily
 * the exact middle) of a singly linked list, given only access to that node.
 * <p>
 * Example:
 * * Input: the node c from the linked list a -> b -> c -> d -> e -> f
 * * Result: nothing is returned, but the updated linked list looks like a -> b -> d -> e -> f
 *
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.3)
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(5);
        list.append(10);
        Node nodeToDelete = list.append(15);
        list.append(20);
        Node last = list.append(25);

        list.print();
        System.out.println(deleteMiddleNode(nodeToDelete));
        list.print();
        System.out.println(deleteMiddleNode(last));
        list.print();
    }

    private static boolean deleteMiddleNode(Node node) {
        if (node == null || node.next == null) return false;

        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
}
