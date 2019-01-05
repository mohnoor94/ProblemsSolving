package search;

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x
 * (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations.
 * That is, implement the method `track(int x)`, which is called when each number is generated,
 * and the method `getRankOfNumber(int x)`, which returns the number of values less than or equal to x (not including
 * x itself).
 * ***
 * Example:
 * - Input: Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 * - getRankOfNumber(1) = 0
 * - getRankOfNumber(3) = 1
 * - getRankOfNumber(4) = 3
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.10)
 */
public class RankFromStream {

    public static void main(String[] args) {
        testSolution(new RankSystem1());
        System.out.println("***");
        testSolution(new RankSystem2());
    }

    private static void testSolution(RankSystem rankSystem) {
        rankSystem.track(5);
        rankSystem.track(1);
        rankSystem.track(4);
        rankSystem.track(4);
        rankSystem.track(5);
        rankSystem.track(9);
        rankSystem.track(7);
        rankSystem.track(13);
        rankSystem.track(3);


        System.out.println(5 + " --> " + rankSystem.getRankOfNumber(5));
        System.out.println(1 + " --> " + rankSystem.getRankOfNumber(1));
        System.out.println(4 + " --> " + rankSystem.getRankOfNumber(4));
        System.out.println(9 + " --> " + rankSystem.getRankOfNumber(9));
        System.out.println(7 + " --> " + rankSystem.getRankOfNumber(7));
        System.out.println(13 + " --> " + rankSystem.getRankOfNumber(13));
        System.out.println(3 + " --> " + rankSystem.getRankOfNumber(3));
        System.out.println(15 + " --> " + rankSystem.getRankOfNumber(15));
        System.out.println(-4 + " --> " + rankSystem.getRankOfNumber(-4));
    }
}

interface RankSystem {
    void track(int x);

    int getRankOfNumber(int x);
}

class RankSystem1 implements RankSystem {
    private Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Time:    O(n)
     * Space:   O(n)
     */
    @Override
    public void track(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            return;
        }

        if (head.data <= x) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prvs = head;
        Node node = head;
        while (node != null && node.data > x) {
            prvs = node;
            node = node.next;
        }

        prvs.next = newNode;
        newNode.next = node;
    }

    /**
     * Time:    O(n); could be enhanced to store the rank but it will still needs O(n) time so I left it as is.
     * Space:   O(n)
     */
    @Override
    public int getRankOfNumber(int x) {
        if (head == null || head.data < x) return -1;

        Node node = head;
        while (node != null && node.data > x) node = node.next;

        int rank = -1;
        while (node != null) {
            rank++;
            node = node.next;
        }

        return rank;
    }
}

class RankSystem2 implements RankSystem {

    private Node node;

    class Node {
        int data;
        int leftSize;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        void insert(int x) {
            if (x <= data) {
                if (left != null) left.insert(x);
                else left = new Node(x);
                leftSize++;
            } else {
                if (right != null) right.insert(x);
                else right = new Node(x);
            }
        }

        int getRank(int x) {
            if (x == data) return leftSize;

            if (x < data) {
                if (left == null) return -1;
                return left.getRank(x);
            } else {
                int rightRank = right == null ? -1 : right.getRank(x);
                if (rightRank == -1) return -1;
                return rightRank + 1 + leftSize;
            }
        }
    }

    /**
     * Time:    O(log n) on a balanced tree ~ O(n) on an unbalanced tree
     * Space:   O(n)
     */
    @Override
    public void track(int x) {
        if (node == null) node = new Node(x);
        else node.insert(x);
    }

    /**
     * Time:    O(log n) on a balanced tree ~ O(n) on an unbalanced tree
     * Space:   O(n)
     */
    @Override
    public int getRankOfNumber(int x) {
        return node.getRank(x);
    }
}