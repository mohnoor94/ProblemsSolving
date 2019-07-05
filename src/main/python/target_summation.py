"""
Given 2 lists of the same size and a target number
Find the closest pair of number that sums up to the target or a closest number to it.

Example:
    - list 1: [-1, 3, 8, 2, 9, 5]
    - list 2: [4, 1, 2, 10, 5, 20]
    - target: 24
    - possible answers: (3, 20), (5, 20)

Problem Statement: https://youtu.be/GBuHSRDGZBY
"""
from typing import List, Tuple


def find_pair1(list1: List[int], list2: List[int], target: int) -> Tuple[int, int] or None:
    """
    - Time: O(x . n)
    - Space: O(n) for the additional set
    * n is the size of the longest list, x is how far the founded summation from the target
    """
    assert len(list1) and len(list2), 'Both lists should have at least 1 element'

    nums = set(list1)

    def targets():
        distance = 0
        while True:
            yield target - distance, target + distance
            distance += 1

    for n in targets():
        for m in list2:
            if n[0] - m in nums:
                return n[0] - m, m
            if n[1] - m in nums:
                return n[1] - m, m

    return None


def find_pair2(list1: List[int], list2: List[int], target: int) -> Tuple[int, int] or None:
    """
    - Time: O(n log n)
    - Space: O(n)
    * n is the size of the longest list
    """
    assert len(list1) and len(list2), 'Both lists should have at least 1 element'

    first = sorted(list1)
    second = sorted(list2)

    i = 0
    j = len(list2) - 1

    smallest_diff = abs(target - (first[0] + second[0]))
    closest_pair = first[0], second[0]

    while i < len(list1) and j >= 0:
        v1 = first[i]
        v2 = second[j]
        diff = v1 + v2 - target

        if diff == 0:
            return v1, v2

        if abs(diff) < smallest_diff:
            smallest_diff = abs(diff)
            closest_pair = v1, v2

        if diff < 0:
            i += 1
        else:
            j -= 1

    return closest_pair


if __name__ == '__main__':
    print(find_pair1([-1, 3, 8, 2, 9, 5], [4, 1, 2, 10, 5, 20], 24))
    print(find_pair2([-1, 3, 8, 2, 9, 5], [4, 1, 2, 10, 5, 20], 24))
    print("=" * 7)
    print(find_pair1([4, 1, 10, 7], [7, 5, 4, 8], 13))
    print(find_pair2([4, 1, 10, 7], [7, 5, 4, 8], 13))
