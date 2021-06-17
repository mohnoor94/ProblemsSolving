"""
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference
equal to the target value.

Example:
    k = 1
    arr = [1, 2, 3, 4

    There are three values that differ by (k=1): (2, 1), (1 ,3), and (4, 3). Return 3.

https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
"""


def pairs(k, arr):
    """
    Time: O(n)
    Space: O(n)
    -
    n: arr length
    """
    values = set()
    count = 0

    for value in arr:
        bigger_found = (value + k) in values
        smaller_found = (value - k) in values

        if smaller_found and bigger_found:
            count += 2
        elif smaller_found or bigger_found:
            count += 1

        values.add(value)

    return count


if __name__ == '__main__':
    # light testing, solution tested on hackerrank.
    print(pairs(2, [1, 5, 3, 4, 2]) == 3)
    print(pairs(2, [1, 3, 5, 8, 6, 4, 2]) == 5)
    print(pairs(1, [363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181,
                    1069262793]) == 0)
