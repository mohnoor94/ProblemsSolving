package sort.algo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class BucketSort implements SortAlgorithm {

    private final int BUCKETS;
    private SortAlgorithm sortAlgorithm;
    private Bucket[] buckets;

    public BucketSort(int bucketsNumber, SortAlgorithm sortAlgorithm) {
        this.BUCKETS = bucketsNumber;
        this.sortAlgorithm = sortAlgorithm;
        buckets = new Bucket[bucketsNumber];

        for (int i = 0; i < buckets.length; i++) buckets[i] = new Bucket();
    }

    public BucketSort() {
        this(10, new QuickSort());
    }

    /**
     * Time:
     * - Avg:   O(n+k)
     * - Worst: same as worst case of internal sortAlgorithm; with QuickSort: O(n^2)
     * ***
     * Space:   O(n)
     * ***
     * n: array size
     * k: time to sort 1 bucket
     * ***
     * BucketSort works only with numbers
     */
    public void sort(int[] array) {
        for (int num : array) buckets[(num / BUCKETS) % BUCKETS].bucket.add(num);

        for (Bucket bucket : buckets) sortBucket(bucket);

        updateArray(array);
    }

    private void updateArray(int[] array) {
        int index = 0;
        for (Bucket bucket : buckets) {
            for (Integer num : bucket.bucket) {
                array[index] = num;
                index++;
            }
        }
    }

    private void sortBucket(Bucket bucket) {
        int[] ints = bucket.bucket.stream().mapToInt(i -> i).toArray();
        sortAlgorithm.sort(ints);

        bucket.bucket = new ArrayList<>();
        for (int num : ints) bucket.bucket.add(num);
    }
}

class Bucket {
    List<Integer> bucket = new ArrayList<>();
}
