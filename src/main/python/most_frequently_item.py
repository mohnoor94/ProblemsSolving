"""
    Find the most frequently occurring item in an array.
    Example: The most frequently occurring item in [1, 3, 1, 3, 2, 1] is 1.
    If you're given an empty array, you should return None (or null).

    You can assume that there is always a single, unique value that appears most frequently unless the array is empty.
    For instance, you won't be given an array such as [1, 1, 2, 2].

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""

from collections import Counter


def most_frequent(nums):
    max_item = None
    counter = Counter()
    if nums:
        max_count = -1
        for n in nums:
            counter[n] += 1
            if counter[n] > max_count:
                max_count = counter[n]
                max_item = n

    return max_item


if __name__ == '__main__':
    print(most_frequent([1, 3, 1, 3, 2, 1]))
    print(most_frequent([3, 3, 1, 3, 2, 1]))
    print(most_frequent([]))
    print(most_frequent([0]))
    print(most_frequent([0, -1, 10, 10, -1, 10, -1, -1, -1, 1]))
