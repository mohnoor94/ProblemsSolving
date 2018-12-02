import datastructure.Node;
import datastructure.SinglyLinkedList;

/**
 * Write a code to partition a singly linked list around a value x, such that all nodes less than x come before all
 * nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see the example).
 * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left
 * and right partitions.
 * ***
 * Example:
 * * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1, partition = 5
 * * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.4)
 */
public class PartitionSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(3);
        list.append(5);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);

        list.print();
        partition(list, 5);
        list.print();
        partition(list, 2);
        list.print();
    }

    /**
     * Time:    O(n), n: size of list
     * Space:   O(n)
     * <p>
     * You can do this using only 1 additional linked list by deleting nodes from the original list and adding them
     * to the new one, then merge the 2 lists at the final step. But this will still use O(n) space and requires us
     * to handle all cases of deleting a node from a linked list, at the beginning, at the end, and in the middle.
     */
    private static void partition(SinglyLinkedList list, int pivot) {
        SinglyLinkedList left = new SinglyLinkedList();
        SinglyLinkedList right = new SinglyLinkedList();

        Node p = list.head;
        while (p != null) {
            if (p.data < pivot) left.append(p.data);
            else right.append(p.data);
            p = p.next;
        }

        left.append(right.head);
        list.head = left.head;
    }
}
