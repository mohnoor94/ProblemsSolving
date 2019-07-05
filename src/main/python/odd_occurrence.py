from collections import Counter


def find_odd_occurred_number_sol1(nums):
    """
    You are given an array of repeating numbers. All numbers repeat in even way, except for
    one. Find the odd occurring number.

    - More details: https://youtu.be/bMF2fG9eY0A

    - Time: O(len(nums))
    - Space: O(len(nums))
    """
    counter = Counter()
    for value in nums:
        counter[value] += 1

    result = None
    for value in counter:
        if counter[value] % 2 != 0:
            result = value
            break

    return result


def find_odd_occurred_number_sol2(nums):
    """
    You are given an array of repeating numbers. All numbers repeat in even way, except for
    one. Find the odd occurring number.

    - This solution takes less space.
    - More details: https://youtu.be/bMF2fG9eY0A

    - Time: O(len(nums))
    - Space: worst: O(len(nums))
    """
    values = set()
    for value in nums:
        if value in values:
            values.remove(value)
        else:
            values.add(value)

    return next(iter(values))


def find_odd_occurred_number_sol3(nums):
    """
    You are given an array of repeating numbers. All numbers repeat in even way, except for
    one. Find the odd occurring number.

    - Time: O(len(nums))
    - Space: O(1)
    """
    xor = 0

    for n in nums:
        xor ^= n

    return xor


if __name__ == '__main__':
    print(find_odd_occurred_number_sol1((1, 2, 3, 1, 3)),
          find_odd_occurred_number_sol2((1, 2, 3, 1, 3)),
          find_odd_occurred_number_sol3((1, 2, 3, 1, 3)))
    print(find_odd_occurred_number_sol1((1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 4, 3, 2, 1)),
          find_odd_occurred_number_sol2((1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 4, 3, 2, 1)),
          find_odd_occurred_number_sol3((1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 4, 3, 2, 1)))
