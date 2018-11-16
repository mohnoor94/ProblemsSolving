"""
    Given two strings, write a method to determine if one is a permutation of the other.

    - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.2)
"""

from collections import Counter


def are_permutations(first, second):
    if len(first) != len(second):
        return False

    counter = Counter()

    for c in first:
        counter[c] += 1

    for c in second:
        counter[c] -= 1
        if counter[c] < 0:
            return False

    return True


if __name__ == '__main__':
    print(are_permutations('hello', 'olleh'))
    print(are_permutations('hello', 'hi'))
    print(are_permutations('hello', 'heLLO'))
    print(are_permutations('hello', 'llohe'))
