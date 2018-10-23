import java.util.PriorityQueue;

/**
 * Find the Running Median
 *
 * Problem statement: https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
@SuppressWarnings("ConstantConditions")
public class RunningMedian {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (double v : getMedians(arr)) {
            System.out.println(v);
        }
    }

    private static double[] getMedians(int[] array) {
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        PriorityQueue<Integer> lowers = new PriorityQueue<>((x, y) -> -1 * x.compareTo(y));
        double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> smallerHeap = lowers;
        PriorityQueue<Integer> biggerHeap = highers;
        if (lowers.size() > highers.size()) {
            smallerHeap = highers;
            biggerHeap = lowers;
        }

        if (biggerHeap.size() == smallerHeap.size())
            return (biggerHeap.peek() + smallerHeap.peek()) / 2.0;
        else return biggerHeap.peek();
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        int lowersSize = lowers.size();
        int higherSize = highers.size();
        if (lowersSize == higherSize) return;
        PriorityQueue<Integer> smallerHeap = lowers;
        PriorityQueue<Integer> biggerHeap = highers;
        if (lowersSize > higherSize) {
            smallerHeap = highers;
            biggerHeap = lowers;
        }

        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.offer(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || number < lowers.peek())
            lowers.offer(number);
        else
            highers.offer(number);
    }
}
