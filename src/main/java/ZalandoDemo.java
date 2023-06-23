
public class ZalandoDemo {
    public static void main(String[] args) {


    }
}


/**
 * def solution(s, c):
 *     cost = 0
 *
 *     for i in range(len(s) - 1):
 *         if s[i] == s[i+1]:
 *             cost += c[i] if c[i] < c[i+1] else c[i+1]
 *
 *     return cost
 */


/*
def find_min_cost(chain, start):
    min_cost = chain[start] + chain[-2]

    for i in range

def solution(chain):
    min_cost = chain[1] + chain[-2]

    for index in range(1, len(chain) - 2):
        cost = find_min_cost(chain, index)
        if cost < min_cost:
            min_cost = cost

    return min_cost
 */


/*
def find_lowest_three(numbers, start, end):
    """
    Find the most minimum 3 numbers (with their indices).

    Time: O(n)
    Space: O(1)

    n: len(numbers) - (start + end).
    """
    if len(numbers) < 3:
        return None

    first = start
    second = start + 1
    third = start + 2

    # find the correct order of the first 3 numbers
    if numbers[first] <= numbers[second] <= numbers[third]:
        lowest, second_lowest, third_lowest =  (numbers[first], first), (numbers[second], second), (numbers[third], third)
    elif numbers[second] <= numbers[first] <= numbers[third]:
        lowest, second_lowest, third_lowest =  (numbers[second], second), (numbers[first], first), (numbers[third], third)
    elif numbers[third] <= numbers[first] <= numbers[second]:
        lowest, second_lowest, third_lowest =  (numbers[third], third), (numbers[first], first), (numbers[second], second)
    elif numbers[first] <= numbers[third] <= numbers[second]:
        lowest, second_lowest, third_lowest =  (numbers[first], first), (numbers[third], third), (numbers[second], second)
    elif numbers[second] <= numbers[third] <= numbers[first]:
        lowest, second_lowest, third_lowest =  (numbers[second], second), (numbers[third], third), (numbers[first], first)
    else:
        lowest, second_lowest, third_lowest =  (numbers[third], third), (numbers[second], second), (numbers[first], first)

    # make adjusments where we find new minimums
    for i in range(start+3, end):
        if numbers[i] < lowest[0]:
            second_lowest = lowest
            third_lowest = second_lowest
            lowest = (numbers[i], i)
        elif numbers[i] < second_lowest[0]:
            third_lowest = second_lowest
            second_lowest = (numbers[i], i)
        elif numbers[i] < third_lowest[0]:
            third_lowest = (numbers[i], i)

    return lowest, second_lowest, third_lowest

def solution(chain):
    """
    Time: O(n)
    Space: O(1)

    n: chain length
    """
    # Find the the most minimum 3 numbers in the chain, excluding the first and the last
    lowest, second_lowest, third_lowest = find_lowest_three(chain, 0, len(chain))

    # return the most 2 minimums unless they are adjacents
    if abs(lowest[1] - second_lowest[1]) > 1:
        return lowest[0] + second_lowest[0]

    return lowest[0] + third_lowest[0]

 */


/*

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    /**
    Time: O(n)
    Space: O(1)

    n: size of s and c

public int solution(String s, int[] c) {
    int cost = 0;

    for (int i = 0; i < s.length() - 1; i++) {
        char current = s.charAt(i);

        int j = i + 1;
        // get all similar and adjacent charcter indices
        while(j < s.length() && s.charAt(j) == current) {
            j++;
        }

        // if there are at least 2 adjacent similar characters
        // add all (but max) cost to the total cost
        if (j > i + 1) {
            cost += findSum(c, i, j) - findMax(c, i, j);
            i = j - 1; // move main curser
        }
    }

    return cost;
}

    /**
     find sum in O(n) time and O(1) space.
     private int findSum(int[] nums, int start, int end) {
        int sum = 0;

        for(int i = start; i < end; i++) {
            sum += nums[i];
        }

        return sum;
    }

    /**
     find max number in O(n) time and O(1) space.

    private int findMax(int[] nums, int start, int end) {
        int max = nums[start];

        for(int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
}


 */


/*
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(s):
    """
    Time: O(n)
    Space: O(1)

    n: length of s
    """
    max_num = s[:2]

    # Move a sliding window to compare all possible charcter pairs with the current max
    for i in range(len(s)):
        if s[i:i+2] > max_num:
            max_num = s[i:i+2]

    return int(max_num)
 */