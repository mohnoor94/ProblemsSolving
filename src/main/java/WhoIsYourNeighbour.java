import java.util.LinkedList;

/**
 * *** 'Amazon' interview question ***
 *
 * Problem: Given a tree of nodes (each node has 3 pointers: left, right, and next), you are required to set the value
 * of the `next` pointer of every node to it's neighbour.
 * The neighbour of any node is the node that comes to the right of that node at the same level, or otherwise.
 *
 * Example:
 * for the tree:
 *            /-----------0-----------\
 *      /----1----\              /----2----\
 *  /--3--\    /--4             5          6
 * 7      8   9
 *
 * The neighbours (per node) should be:
 * 0 --> null
 * 1 --> 2
 * 2 --> null
 * 3 --> 4
 * 4 --> 5
 * 5 --> 6
 * 6 --> null
 * 7 --> 8
 * 8 --> 9
 * 9 --> null
 */
public class WhoIsYourNeighbour {

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        setNeighbours(root);
        root.printNeighbour();
    }

    private static void setNeighbours(Node root) {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addLast(root);
        nodes.addLast(null);
        while (nodes.size() > 1) {
            Node first = nodes.removeFirst();
            if (first != null) {
                first.next = nodes.peek();
                if (first.hasLeft()) nodes.addLast(first.left);
                if (first.hasRight()) nodes.addLast(first.right);
            } else {
                nodes.addLast(null);
            }
        }
    }

    static class Node {
        int data;
        Node left, right, next;

        Node(int data) {
            this.data = data;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        boolean hasNext() {
            return next != null;
        }

        // for testing purposes
        void printNeighbour() {
            System.out.println(data + " --> " + (hasNext() ? next.data : null));
            if (hasLeft()) left.printNeighbour();
            if (hasRight()) right.printNeighbour();
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}