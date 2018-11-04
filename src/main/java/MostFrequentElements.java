import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * *** 'Facebook' interview question ***
 * <p>
 * Problem: K Most Frequent Elements
 * <p>
 * Problem statement: https://youtu.be/EYFcQRwcqk0
 */
public class MostFrequentElements {

    public static void main(String[] args) {
        System.out.println(findMostFrequentElements1(1, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements1(2, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements1(3, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements1(3, new int[]{1}));
        System.out.println(findMostFrequentElements1(3, new int[]{1, 1, 1, 1, 2}));
        System.out.println(findMostFrequentElements1(0, new int[]{1, 1, 1, 1, 2}));
        System.out.println("=========");
        System.out.println(findMostFrequentElements2(1, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements2(2, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements2(3, new int[]{1, 6, 2, 1, 6, 1}));
        System.out.println(findMostFrequentElements2(3, new int[]{1}));
        System.out.println(findMostFrequentElements2(3, new int[]{1, 1, 1, 1, 2}));
        System.out.println(findMostFrequentElements2(0, new int[]{1, 1, 1, 1, 2}));
    }

    private static List<Integer> findMostFrequentElements1(int k, int[] numbers) {
        ArrayList<Integer> mostFrequent = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((x, y) -> -1 * x[1].compareTo(y[1]));

        for (int number : numbers) counter.compute(number, (key, val) -> val == null ? 1 : val + 1);

        counter.forEach((key, val) -> queue.add(new Integer[]{key, val}));

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            mostFrequent.add(queue.remove()[0]);
        }

        return mostFrequent;
    }

    private static List<Integer> findMostFrequentElements2(int k, int[] numbers) {
        ArrayList<Integer> mostFrequent = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int number : numbers) counter.compute(number, (key, val) -> val == null ? 1 : val + 1);

        @SuppressWarnings("unchecked") ArrayList<Integer>[] buckets = new ArrayList[numbers.length + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();

        counter.forEach((key, val) -> buckets[val].add(key));

        int i = buckets.length - 1;
        while (i > 0 && mostFrequent.size() < k) {
            ArrayList<Integer> bucket = buckets[i];
            if (!bucket.isEmpty()) mostFrequent.add(bucket.remove(bucket.size() - 1));
            if (bucket.isEmpty()) i--;
        }

        return mostFrequent;
    }
}