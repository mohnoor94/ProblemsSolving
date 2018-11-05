"""
    Is One Array a Rotation of Another?

    Write a function that returns True if one array is a rotation of another.
    Example: [1, 2, 3, 4, 5, 6, 7] is a rotation of [4, 5, 6, 7, 1, 2, 3].
    NOTE: There are no duplicates in each of these arrays.

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""


def is_rotation(list1, list2):
    """
    Time:   O(n)
    Space:  O(1)
    """
    if len(list1) != len(list2):
        return False

    list1index = 0
    list2index = -1
    if list1[0] in list2:
        list2index = list2.index(list1[0])
    if list2index == -1:
        return False

    while list1index < len(list1):
        if list1[list1index] != list2[list2index]:
            return False
        else:
            list1index += 1
            list2index = (list2index + 1) % len(list2)

    return True


if __name__ == "__main__":
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [4, 5, 6, 7, 8, 1, 2, 3]))
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [4, 5, 6, 7, 1, 2, 3]))
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [4, 5, 6, 9, 1, 2, 3]))
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [4, 6, 5, 7, 1, 2, 3]))
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [4, 5, 6, 7, 0, 2, 3]))
    print(is_rotation([1, 2, 3, 4, 5, 6, 7], [1, 2, 3, 4, 5, 6, 7]))
