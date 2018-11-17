import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * > Follow up: how could you solve this problem if a temporary buffer is not allowed?
 *
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.1)
 */
public class RemoveDups {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.append(5);
        list.append(10);
        list.append(20);
        list.append(20);
        list.append(10);
        list.append(5);

        list.print();

        list.removeDuplicates();

        list.print();
    }

}

class LinkedList {
    private Node head;

    LinkedList(int headData) {
        head = new Node(headData);
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void append(int data) {
        Node p = head;
        while (p.next != null) p = p.next;
        p.next = new Node(data);
    }

    /**
     * Time:    O(n)
     * Space:   O(n)
     *
     * We can solve this with O(1) space but with nested loop and 2 pointers, which results in O(n^2).
     */
    void removeDuplicates() {
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

    void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println();
    }
}