"""
*** 'Airbnb' interview question ***

Problem statement: https://youtu.be/cdCeU8DJvPM
"""
from numbers import Number
from typing import List


def find_missing1(first: list, second: list) -> Number:
    """
    - Time Complexity: O(len(first))
    - Space Complexity: O(len(first))

    :param first: a list of items
    :param second: a copy of the first list but with one missing item
    :return: the missed item
    """
    set1 = set(first)
    set2 = set(second)

    for item in set1:
        if item not in set2:
            return item

    return None


def find_missing2(first: list, second: list) -> Number:
    """
    - Time Complexity: O(len(first))
    - Space Complexity: O(len(first))

    :param first: a list of items
    :param second: a copy of the first list but with one missing item
    :return: the missed item
    """
    return list(set(first) - set(second))[0]


def find_missing3(first: List[Number], second: List[Number]) -> Number:
    """
    - Time Complexity: O(len(first))
    - Space Complexity: O(1) <-- can be more for bigger numbers

    :param first: a list of items
    :param second: a copy of the first list but with one missing item
    :return: the missed item
    """
    return sum(first) - sum(second)


def find_missing4(first: List[Number], second: List[Number]) -> Number:
    """
    - Time Complexity: O(len(first))
    - Space Complexity: O(1)

    :param first: a list of items
    :param second: a copy of the first list but with one missing item
    :return: the missed item
    """
    xor_sum = 0

    for n in first:
        xor_sum ^= n
    for n in second:
        xor_sum ^= n

    return xor_sum


if __name__ == '__main__':
    print(find_missing1([4, 12, 9, 5, 6], [4, 9, 12, 6]))
    print(find_missing2([4, 12, 9, 5, 6], [4, 9, 12, 6]))
    print(find_missing3([4, 12, 9, 5, 6], [4, 9, 12, 6]))
    print(find_missing4([4, 12, 9, 5, 6], [4, 9, 12, 6]))
