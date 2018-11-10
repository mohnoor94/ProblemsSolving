/**
 * N-th Element (from the end) of a Linked List
 *
 * Implement a function that finds the nth node in a linked list, counting from the end.
 * Your function should take a linked list (its head element) and n, a positive integer as its arguments.
 *
 * Example (1):
 * head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
 * The third element of head counting from the end is 3.
 *
 * Example(2):
 * head2 = 1 -> 2 -> 3 -> 4 -> (null / None)
 * The fourth element of head2 counting from the end is 1.
 *
 * If the given n is larger than the number of nodes in the list, return null.
 *
 * - More details: https://www.udemy.com/11-essential-coding-interview-questions/
 */
public class NthElementInLinkedList {

    private static class Node {
        int value;
        Node child;

        Node(int value, Node child) {
            this.value = value;
            this.child = child;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current; // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2; // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        System.out.println(nthFromLastUsingPointers(head, 1)); // 1
        System.out.println(nthFromLastUsingPointers(head, 5)); // 5
        System.out.println(nthFromLastUsingPointers(head2, 3)); // 2
        System.out.println(nthFromLastUsingPointers(head2, 4)); // 1
        System.out.println(nthFromLastUsingPointers(head2, 5)); // null
        System.out.println(nthFromLastUsingPointers(null, 1)); // null
    }

    /**
     * Time:    O(s), s: size of the list
     * Space:   O(n) = O(1), n: nth elements
     *
     * This solution is simpler and requires less space
     */
    private static Node nthFromLastUsingPointers(Node head, int n) {
        Node pointer1 = head;
        Node pointer2 = head;
        while (n > 0) {
            if (pointer2 == null) return null;
            pointer2 = pointer2.child;
            n--;
        }
        while (pointer2 != null) {
            pointer1 = pointer1.child;
            pointer2 = pointer2.child;
        }
        return pointer1;
    }

    /**
     * Time:    O(s), s: size of the list
     * Space:   O(n) = O(1), n: nth elements
     */
    private static Node nthFromLastUsingArray(Node head, int n) {
        if (head == null) return null;
        Node[] memo = new Node[n];
        Node curr = head;
        int i = 0;
        while (curr != null) {
            memo[i++ % n] = curr;
            curr = curr.child;
        }
        if (i < n) return null;
        return memo[i % n];
    }
}
