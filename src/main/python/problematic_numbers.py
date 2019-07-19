"""
    *** 'Google' interview question ***
    A problematic number is a number that can still be a valid number if you flipped it.
    Write a function that find problematic numbers within a list.

    Examples:
        - 1 : 1 : problematic
        - 2 : not problematic
        - 8 : 8 : problematic
        - 88 : 88 : problematic
        - 83 : not problematic
"""
from typing import List


def find_problematic(numbers) -> List[int]:
    """
    - Time: O(n * m)
    - Space: O(n * m)
    * n = len(numbers)
    * m = len(largest number in numbers)
    """
    non_problematic = {'2', '3', '4', '5', '7'}
    result = []

    for number in numbers:
        n = str(number)
        skip = False
        for d in n:
            if d in non_problematic:
                skip = True
                break
        if not skip:
            result.append(number)
    return result


if __name__ == '__main__':
    print(find_problematic(range(11)))
    print(find_problematic(range(101)))
    print(find_problematic(range(1001)))
