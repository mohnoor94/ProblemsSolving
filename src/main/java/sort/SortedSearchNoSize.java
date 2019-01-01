package sort;

import java.util.ArrayList;

/**
 * 'Sorted Search, No Size'
 * You are given an array-like data structure `Listy` which lacks a size method.
 * It does, however, have an `elementAt(i)` method that returns the element at index i in O(1) time.
 * If i beyond the bounds of the data structure, it returns -1. (For this reason, the data structure only
 * supports positive integers).
 * Given a `Listy` which contains sorted, positive integers, find the index at which an element x occurs.
 * If x occurs multiple times, you may return any index.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 10.4)
 */
public class SortedSearchNoSize {

    public static void main(String[] args) {
        Listy listy = new Listy(2, 2, 2, 3, 5, 5, 10, 10, 10, 13, 13, 20, 20);

        // note: all solutions take o(log (n)) time but the third is the best one

        testSolution(listy, new ListySearchFirstSolution());

        System.out.println("***");

        testSolution(listy, new ListySearchSecondSolution());

        System.out.println("***");

        testSolution(listy, new ListySearchThirdSolution());
    }

    private static void testSolution(Listy listy, ListySearchSolution firstSolution) {
        System.out.println(firstSolution.solve(listy, 10));
        System.out.println(firstSolution.solve(listy, 13));
        System.out.println(firstSolution.solve(listy, 18));
        System.out.println(firstSolution.solve(listy, 1));
        System.out.println(firstSolution.solve(listy, -5));
    }
}

class Listy {
    private ArrayList<Integer> list;

    Listy(int... nums) {
        list = new ArrayList<>();
        for (int num : nums) if (num >= 0) list.add(num);
    }

    int elementAt(int index) {
        return (index >= 0 && index < list.size()) ? list.get(index) : -1;
    }
}

interface ListySearchSolution {
    int solve(Listy listy, int goal);
}

class ListySearchFirstSolution implements ListySearchSolution {

    @Override
    public int solve(Listy listy, int goal) {
        if (listy == null || goal < listy.elementAt(0) || listy.elementAt(0) == -1) return -1;
        return solve(listy, goal, 10, false);
    }

    private int solve(Listy listy, int goal, int guess, boolean strictSearch) {
        int x = listy.elementAt(guess);
        if (x == goal) return guess;
        if (x == -1) return solve(listy, goal, guess / 2, strictSearch);

        if (x > goal) {
            if (listy.elementAt(guess - 1) >= goal) return solve(listy, goal, guess / 2, true);
            return -1;
        }

        if (!strictSearch) return solve(listy, goal, guess * 2, listy.elementAt(guess * 2) == -1);

        return listy.elementAt(guess + 1) == -1 ? -1 : solve(listy, goal, guess + 1, true);
    }
}

class ListySearchSecondSolution implements ListySearchSolution {

    @Override
    public int solve(Listy listy, int goal) {
        int lastIndex = findLastIndexBefore(listy, goal);
        return binarySearch(listy, goal, lastIndex / 2, lastIndex);
    }

    private int binarySearch(Listy listy, int goal, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;
        int midItem = listy.elementAt(mid);

        if (midItem > goal) return binarySearch(listy, goal, first, mid - 1);
        if (midItem < goal) return binarySearch(listy, goal, mid + 1, last);

        return mid;
    }

    private int findLastIndexBefore(Listy listy, int goal) {
        int guess = 1;
        while (listy.elementAt(guess) != -1 && listy.elementAt(guess) < goal) guess *= 2;
        while (listy.elementAt(guess) == -1 && guess >= 0) guess -= 1;
        return guess;
    }
}

class ListySearchThirdSolution implements ListySearchSolution {

    @Override
    public int solve(Listy listy, int goal) {
        int index = 1;
        while (listy.elementAt(index) != -1 && listy.elementAt(index) < goal) index *= 2;

        return binarySearch(listy, goal, index / 2, index);
    }

    private int binarySearch(Listy listy, int goal, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;
        int midItem = listy.elementAt(mid);

        if (midItem > goal || midItem == -1) return binarySearch(listy, goal, first, mid - 1);
        if (midItem < goal) return binarySearch(listy, goal, mid + 1, last);

        return mid;
    }
}