"""
    Rotating a 2D Array by 90 Degrees
    Implement a function that takes a square  2D array (# columns = # rows) and rotates it by 90 degrees.

    Example:
    [[1,2,3],
     [4,5,6],
     [7,8,9]]
     Will be rotated to:
     [[7,4,1],
      [8,5,2],
      [9,6,3]]

  - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""
import math


def rotate(given_array):
    """
    n = # rows = # columns in the given 2d array.

    Time:   O(rows * cols)
    Space:  O(2*1) = O(1)
    """
    n = len(given_array)
    rotated = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        for j in range(n):
            rotated[j][n - 1 - i] = given_array[i][j]
    return rotated


def rotate_inplace(array):
    """
    n = # rows = # columns in the given 2d array.

    Time:   O(rows * cols)
    Space:  O(1)
    """
    n = len(array)
    for i in range(math.ceil(n / 2)):
        for j in range(math.floor(n / 2)):
            tmp = [()] * 4
            (current_i, current_j) = (i, j)
            for k in range(4):
                tmp[k] = array[current_i][current_j]
                (current_i, current_j) = (current_j, n - 1 - current_i)
            for k in range(4):
                array[current_i][current_j] = tmp[(k + 3) % 4]
                (current_i, current_j) = (current_j, n - 1 - current_i)
    return array


def to_string(given_array):
    """
    Converts a 2-dimensional array (a list of lists) into an easy-to-read string format
    """
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'


if __name__ == '__main__':
    a1 = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
    a2 = [[1, 2, 3, 4],
          [5, 6, 7, 8],
          [9, 10, 11, 12],
          [13, 14, 15, 16]]
    print(to_string(rotate(a1)))
    print()
    print(to_string(rotate_inplace(a1)))
    print('\n')
    print(to_string(rotate(a2)))
    print()
    print(to_string(rotate_inplace(a2)))
