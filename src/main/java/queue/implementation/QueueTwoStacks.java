package queue.implementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static junit.framework.TestCase.assertEquals;


/**
 * Implement a queue with 2 stacks.
 * Your queue should have an enqueue and a dequeue method and it should be "first in first out" (FIFO).
 * *
 * Optimize for the time cost of mm calls on your queue.
 * These can be any mix of enqueue and dequeue calls.
 * Assume you already have a stack implementation and it gives O(1) time push and pop.
 * ***
 * https://www.interviewcake.com/question/queue-two-stacks?course=fc1&section=queues-stacks
 */

public class QueueTwoStacks {
    private final Deque<Integer> inStack = new ArrayDeque<>();
    private final Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }

            if (outStack.isEmpty()) {
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            }
        }

        return outStack.pop();
    }


    // tests
    @Test
    public void basicQueueOperationsTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromNewQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.dequeue();
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromEmptyQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(QueueTwoStacks.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}