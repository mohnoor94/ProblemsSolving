package datastructure.linkedlist;

import datastructure.linkedlist.implementation.SinglyLinkedList;
import datastructure.node.implementation.Node;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * > Follow up: how could you solve this problem if a temporary buffer is not allowed?
 *
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.1)
 */
public class RemoveDups {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(5);
        list.append(10);
        list.append(20);
        list.append(20);
        list.append(10);
        list.append(5);

        list.print();
        removeDuplicates(list.head);
        list.print();
    }

    /**
     * Time:    O(n)
     * Space:   O(n)
     *
     * We can solve this with O(1) space but with nested loop and 2 pointers, which results in O(n^2).
     */
    private static void removeDuplicates(Node head) {
        HashSet<Integer> shown = new HashSet<>();
        Node p = head;
        shown.add(p.data);

        while (p != null && p.next != null) {
            if (shown.contains(p.next.data)) {
                p.next = p.next.next;
            } else {
                shown.add(p.next.data);
                p = p.next;
            }
        }
    }

}