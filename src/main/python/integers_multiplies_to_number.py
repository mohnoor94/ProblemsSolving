"""
 'Google' and 'Amazon' interview question ***
 2-Part problem
 1 - Find 2 integers that multiplies to a certain number n.
 2 - Find 3 integers that multiplies to a certain number n.
"""


def find_2_integers_multiplies_to_number(numbers, goal):
    """
    Part 1 - Find 2 integers that multiplies to a certain number n.
    Time:   O(n)
    Space:  O(n)
    """
    shown = set()
    result = None
    for n in numbers:
        if goal // n in shown:
            result = (n, goal // n)
        else:
            shown.add(n)
    return result


def find_3_integers_multiplies_to_number(numbers, goal):
    """
    Part 2 - Find 3 integers that multiplies to a certain number n.
    Time:   O(n^2)
    Space:  O(n)
    """
    result = None
    for n in numbers:
        numbers.remove(n)
        if len(numbers) >= 2:
            sub_result = find_2_integers_multiplies_to_number(numbers, goal // n)
            if sub_result is not None and sub_result[0] * sub_result[1] * n == goal:
                result = (sub_result[0], sub_result[1], n)
    return result


if __name__ == '__main__':
    print(find_2_integers_multiplies_to_number([1, 2, 3, 4, 5], 20))
    print(find_2_integers_multiplies_to_number([-5, 4, 3, 2, 4, 1, 5], 20))
    print(find_2_integers_multiplies_to_number([-5, 4, 3, 2, 4, 1], 20))
    print()
    print(find_3_integers_multiplies_to_number([1, 2, 3, 4, 5], 60))
    print(find_3_integers_multiplies_to_number([1, 2, 3, 4, 5], 55))
    print(find_3_integers_multiplies_to_number([3], 27))
    print(find_3_integers_multiplies_to_number([3, 4], 27))
    print(find_3_integers_multiplies_to_number([3, 4, 3], 27))
    print(find_3_integers_multiplies_to_number([3, 3, 3], 27))
