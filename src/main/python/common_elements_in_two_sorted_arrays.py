"""
    Common Elements in Two Sorted Arrays

    Write a function that returns the common elements (as an array)
    between two sorted arrays of integers (ascending order).

    Example: The common elements between [1, 3, 4, 6, 7, 9] and [1, 2, 4, 5, 9, 10] are [1, 4, 9].

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""


def common_elements_solution1(list1, list2):
    """
    Time:   O(max(n, m)), n,m: sizes of list1, list2.
    Space:  O(max(n, m))
    """
    result = []
    list1set = set(list1)
    for n in list2:
        if n in list1set:
            result.append(n)
    return result


def common_elements_solution2(list1, list2):
    """
    Time:   O(max(n, m)), n,m: sizes of list1, list2.
    Space:  O(min(n, m))
    """
    result = []
    i = j = 0
    while i < len(list1) and j < len(list2):
        if list1[i] == list2[j]:
            result.append(list1[i])
            i += 1
            j += 1
        elif list1[i] > list2[j]:
            j += 1
        else:
            i += 1

    return result


if __name__ == '__main__':
    print(common_elements_solution1([1, 3, 4, 6, 7, 9], [1, 2, 4, 5, 9, 10]))
    print(common_elements_solution1([1, 2, 9, 10, 11, 12], [0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15]))
    print(common_elements_solution1([0, 1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11]))
    print(common_elements_solution1([13, 27, 35, 40, 49, 55, 59], [17, 35, 39, 40, 55, 58, 60]))
    print()
    print(common_elements_solution2([1, 3, 4, 6, 7, 9], [1, 2, 4, 5, 9, 10]))
    print(common_elements_solution2([1, 2, 9, 10, 11, 12], [0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15]))
    print(common_elements_solution2([0, 1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11]))
    print(common_elements_solution2([13, 27, 35, 40, 49, 55, 59], [17, 35, 39, 40, 55, 58, 60]))

