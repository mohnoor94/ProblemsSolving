package select;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NthOrderStatistics {

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 5, 4, 2, 10, 1, 5);

        System.out.println(findNthElement1(list, 1));
        System.out.println(findNthElement1(list, 2));
        System.out.println(findNthElement1(list, 3));

        System.out.println("===========================");

        System.out.println(findNthElement2(list, 1));
        System.out.println(findNthElement2(list, 2));
        System.out.println(findNthElement2(list, 3));

        System.out.println("===========================");

        int[] nums = {3, 5, 4, 2, 10, 1, 5};

        System.out.println(findNthElement3(nums, 1));
        System.out.println(findNthElement3(nums, 2));
        System.out.println(findNthElement3(nums, 3));
    }

    /**
     * Time: O(n log(n))
     * Space: O(n)
     * n = numbers.size()
     */
    private static int findNthElement1(List<Integer> numbers, int n) {
        if (n >= numbers.size()) {
            throw new RuntimeException("n is out of bounds! {List size: " + numbers.size() + ", n: " + n + "}");
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(numbers);

        while (n-- > 1) q.poll();

        return q.poll();
    }


    /**
     * Time: O(n log(n))
     * Space: O(n), could be O(1) if we do the sorting in-place
     * n = numbers.size()
     */
    private static int findNthElement2(List<Integer> numbers, int n) {
        if (n > numbers.size()) {
            throw new RuntimeException("n is out of bounds! {List size: " + numbers.size() + ", n: " + n + "}");
        }

        ArrayList<Integer> tmpList = new ArrayList<>(numbers);
        tmpList.sort(Integer::compareTo);
        return tmpList.get(n - 1);
    }


    /**
     * Time:
     * Space:
     * n = numbers.size()
     */
    private static int findNthElement3(int[] numbers, int n) {
        if (n > numbers.length) {
            throw new RuntimeException("n is out of bounds! {List size: " + numbers.length + ", n: " + n + "}");
        }

        return select(numbers, 0, numbers.length - 1, n - 1);
    }

    private static int select(int[] numbers, int start, int end, int k) {
        int pivot = partition(numbers, start, end);

        if (k > pivot) return select(numbers, pivot + 1, end, k);
        else if (k < pivot) return select(numbers, start, pivot, k);

        return numbers[pivot];
    }

    @SuppressWarnings("Duplicates")
    private static int partition(int[] numbers, int start, int end) {
        int pivot = (start + end) / 2;
        swap(numbers, pivot, end);

        for (int i = start; i < end; i++) {
            if (numbers[i] < numbers[end]) {
                swap(numbers, i, start);
                start++;
            }
        }

        swap(numbers, start, end);
        return start;
    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

}