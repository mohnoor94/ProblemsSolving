package recursion_and_dynamic_programminng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Write a method to return all subsets of a set.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 8.4)
 */
public class PowerSet {

    public static void main(String[] args) {
        System.out.println(getSubsets(null));
        System.out.println(getSubsets(new ArrayList<>(Collections.emptyList())));
        System.out.println(getSubsets(new ArrayList<>(Collections.singletonList(1))));
        System.out.println(getSubsets(new ArrayList<>(Arrays.asList(1, 2))));
        System.out.println(getSubsets(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(getSubsets(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        System.out.println(getSubsets(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
    }

    /**
     * Time:    O(n * 2^n)
     * Space:   O(n * 2^n)
     * ***
     * We cannot do any better for both time and space.
     * Since we have to return all of (2^n) possible subset of a set, and every time we have to close all previous (n)
     * subsets and build on them, which adds the (n) factor.
     * Similarly, for the space we want to store a 2^n subsets with each contains up to n entries.
     */
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        if (set == null) return null;

        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        if (set.isEmpty()) return subsets;

        return getSubsets(set, subsets);
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> subsets) {
        if (set.isEmpty()) return subsets;

        Integer last = set.get(set.size() - 1);
        ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>(subsets);
        for (ArrayList<Integer> subset : subsets) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(last);
            newSubsets.add(newSubset);
        }

        set.remove(set.size() - 1);
        return getSubsets(set, newSubsets);
    }
}
