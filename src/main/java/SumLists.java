import util.Node;
import util.Utils;

/**
 * Part I:
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds two numbers and returns the sum as a linked list.
 * ***
 * Example:
 * * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 * * Output: (2 -> 1 -> 9). That is, 912
 * ***
 * Part II:
 * Suppose the digits are stored in forward order. Repeat the problem in Part I.
 * ***
 * Example:
 * * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295
 * * Output: (9 -> 1 -> 2). That is, 912
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 2.5)
 */
@SuppressWarnings("ConstantConditions")
public class SumLists {

    public static void main(String[] args) {
        testAddBackward(); // part I
        testAddForward(); // par2 II
    }

    private static Node addBackward(Node n1, Node n2) {
        return addBackwardHelper(n1, n2, 0);
    }

    private static Node addForward(Node n1, Node n2) {
        int length1 = Utils.getLength(n1);
        int length2 = Utils.getLength(n2);

        if (length1 > length2)
            n2 = padWithZeros(n2, length1 - length2);
        else if (length2 > length1)
            n1 = padWithZeros(n1, length2 - length1);

        PartialSum sum = addForwardHelper(n1, n2);

        return sum.carry == 0
                ? sum.sum
                : Utils.insertBefore(sum.sum, sum.carry);
    }

    private static Node addBackwardHelper(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) return null;
        int val = carry;

        if (n1 != null) {
            val += n1.data;
            n1 = n1.next;
        }

        if (n2 != null) {
            val += n2.data;
            n2 = n2.next;
        }

        Node result = new Node(val % 10);
        result.next = addBackwardHelper(n1, n2, val / 10);

        return result;
    }

    private static PartialSum addForwardHelper(Node n1, Node n2) {
        if (n1 == null && n2 == null) return new PartialSum(null, 0);

        PartialSum sum = addForwardHelper(n1.next, n2.next);

        int val = sum.carry + n1.data + n2.data;
        sum.sum = Utils.insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;

        return sum;
    }


    private static Node padWithZeros(Node node, int numOfZeros) {
        for (int i = 0; i < numOfZeros; i++) {
            node = Utils.insertBefore(node, 0);
        }
        return node;
    }


    private static void testAddBackward() {
        Node n1 = new Node(7);
        Node n1Next = new Node(1);
        n1.next = n1Next;
        n1Next.next = new Node(6);

        Node n2 = new Node(5);
        Node n2Next = new Node(9);
        n2.next = n2Next;
        n2Next.next = new Node(2);

        Node result = addBackward(n1, n2);

        result.print();
    }

    private static void testAddForward() {
        Node n1 = new Node(6);
        Node n1Next = new Node(1);
        n1.next = n1Next;
        n1Next.next = new Node(7);

        Node n2 = new Node(2);
        Node n2Next = new Node(9);
        n2.next = n2Next;
        n2Next.next = new Node(5);

        Node result = addForward(n1, n2);

        result.print();
    }
}

/**
 * We need this since we need to return 2 values from a method
 */
class PartialSum {
    Node sum;
    int carry;

    PartialSum(Node sum, int carry) {
        this.sum = sum;
        this.carry = carry;
    }
}