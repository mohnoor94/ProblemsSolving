import java.util.ArrayList;
import java.util.List;

/**
 * *** 'Google' interview question ***
 * Build a queue using a stack.
 *
 * More details: https://youtu.be/71kEvXsEKYQ
 */
public class QueueUsingStack {

    public static void main(String[] args) {
        testIntegersQueue(new QueueUsing2Stacks<>());
        System.out.println("=======================");
        testIntegersQueue(new QueueUsing1Stack<>());
    }

    private static void testIntegersQueue(Queue<Integer> queue) {
        for (int i = 1; i <= 5; i++) queue.enQueue(i);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println();

        for (int i = 6; i <= 10; i++) queue.enQueue(i);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println();

        while (!queue.isEmpty()) System.out.print(queue.deQueue() + ", ");
        System.out.println();
    }

    interface Queue<T> {
        void enQueue(T elem);

        T deQueue();

        boolean isEmpty();
    }

    static class QueueUsing2Stacks<T> implements Queue<T> {
        private SimpleStack<T> enqueueStack = new SimpleStack<>();
        private SimpleStack<T> dequeueStack = new SimpleStack<>();

        @Override
        public void enQueue(T elem) {
            while (!dequeueStack.isEmpty())
                enqueueStack.push(dequeueStack.pop());

            enqueueStack.push(elem);
        }

        @Override
        public T deQueue() {
            if (isEmpty()) throw new RuntimeException("Empty Queue");

            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());

            return dequeueStack.pop();
        }

        @Override
        public boolean isEmpty() {
            return enqueueStack.isEmpty() && dequeueStack.isEmpty();
        }
    }

    static class QueueUsing1Stack<T> implements Queue<T> {
        private SimpleStack<T> stack = new SimpleStack<>();

        @Override
        public void enQueue(T elem) {
            stack.push(elem);
        }

        @Override
        public T deQueue() {
            if (isEmpty()) throw new RuntimeException("Empty Queue");
            return getFirst();
        }

        private T getFirst() {
            if (stack.size() == 1) return stack.pop();
            T elem = stack.pop();
            T result = deQueue();
            stack.push(elem);
            return result;
        }

        @Override
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    static class SimpleStack<T> {
        private List<T> list = new ArrayList<>();

        void push(T elem) {
            list.add(elem);
        }

        T pop() {
            return list.remove(list.size() - 1);
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        int size() {
            return list.size();
        }
    }
}