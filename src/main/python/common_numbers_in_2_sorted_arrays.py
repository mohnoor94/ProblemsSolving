"""
    Given two sorted arrays, find the number of elements in common. The arrays are the same length and each has all
    distinct elements.

    - Cracking the coding interview, a book by Gayle Mcdowell. pg72
"""


def count_common_numbers(a, b):
    """
    Time:   O(n)
    Space:  O(1)

    We can easily return the common numbers in a list instead of only counting them.
    """
    i = j = count = 0
    length = len(a)  # a and b are the same length
    while i < length and j < length:
        if i < length and j < length and a[i] < b[j]:
            i += 1
        if i < length and j < length and b[j] < a[i]:
            j += 1
        if i < length and j < length and a[i] == b[j]:
            count += 1
            i += 1
            j += 1
    return count


if __name__ == '__main__':
    print(count_common_numbers([13, 27, 35, 40, 49, 55, 59], [17, 35, 39, 40, 55, 58, 60]))
