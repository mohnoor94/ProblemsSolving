package linkedlist;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * You have a linked list ↴ and want to find the kth to last node.
 * Write a method kthToLastNode() that takes an integer k and the headNode of a singly-linked list, and returns the
 * kth to last node in the list.
 * ***
 * https://www.interviewcake.com/question/kth-to-last-node-in-singly-linked-list?course=fc1&section=linked-lists
 */
public class KthToLast {

    /**
     * Time: O(n)
     * Space: O(1)
     * -
     * n: number of nodes / length of the list
     * ---
     * In both cases, we have two pointers taking the same steps through our list.
     * The only difference is the order in which the steps are taken. The number of steps is the same either way.
     * -
     * However, the second approach might still be slightly faster, due to some caching and other optimizations that
     * modern processors and memory have.
     * -
     * Let's focus on caching. Usually when we grab some data from memory (for example, info about a linked list node),
     * we also store that data in a small cache right on the processor. If we need to use that same data again soon
     * after, we can quickly grab it from the cache. But if we don't use that data for a while, we're likely to replace
     * it with other stuff we've used more recently (this is called a "least recently used" replacement policy).
     * -
     * Both of our algorithms access a lot of nodes in our list twice, so they could exploit this caching.
     * But notice that in this algorithm there's a much shorter time between the first and second times that we
     * access a given node (this is sometimes called "temporal locality of reference").
     * Thus it seems more likely that our second algorithm will save time by using the processor's cache! But this
     * assumes our processor's cache uses something like a "least recently used" replacement policy—it might use
     * something else.
     * Ultimately the best way to really know which algorithm is faster is to implement both and time them on a few
     * different inputs!
     */
    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (k <= 0) throw new RuntimeException("Seriously?");

        LinkedListNode left = head;
        LinkedListNode right = head;

        for (int i = 0; i < k - 1; i++) {
            if (right.next == null) throw new RuntimeException("Run out of nodes!");
            right = right.next;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }


    /**
     * Time: O(n)... actually, (O (2*n))
     * Space: O(1)
     * -
     * n: number of nodes / length of the list
     */
    public static LinkedListNode kthToLastNode2(int k, LinkedListNode head) {
        if (k <= 0) throw new RuntimeException("Seriously?");

        int listLength = 1;
        LinkedListNode currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            listLength += 1;
        }

        int howFarToGo = listLength - k;
        if (howFarToGo < 0) throw new RuntimeException("Run out of nodes!");

        currentNode = head;
        for (int i = 0; i < howFarToGo; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    // tests
    @Test
    public void firstToLastNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final int k = 1;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void secondToLastNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final int k = 2;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void firstNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final int k = 4;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test(expected = Exception.class)
    public void kIsGreaterThanLinkedListLengthTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final int k = 5;
        kthToLastNode(k, listNodes[0]);
    }

    @Test(expected = Exception.class)
    public void kIsZeroTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final int k = 0;
        kthToLastNode(k, listNodes[0]);
    }

    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(KthToLast.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}