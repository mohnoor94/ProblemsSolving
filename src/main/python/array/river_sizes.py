# https://www.algoexpert.io/questions/river-sizes

# You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only 0s and 1s.
# Each 0 represents land, and each 1 represents part of a river. A river consists of any number of 1s that are either
# horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river
# determine its size. Write a function that returns an array of the sizes of all rivers represented in the input
# matrix. Note that these sizes do not need to be in any particular order.

# Sample Input
# matrix = [
#   [1, 0, 0, 1, 0],
#   [1, 0, 1, 0, 0],
#   [0, 0, 1, 0, 1],
#   [1, 0, 1, 0, 1],
#   [1, 0, 1, 1, 0],
# ]

# Sample Output
# [1, 2, 2, 2, 5]

def river_sizes(matrix):
    sizes = []

    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] == 1:
                sizes.append(measure_length(matrix, i, j))

    return sizes


def measure_length(matrix, i, j, length=1):
    matrix[i][j] = -1

    if j + 1 < len(matrix[i]) and matrix[i][j + 1] == 1:
        length = 1 + measure_length(matrix, i, j + 1, length)

    if j > 0 and matrix[i][j - 1] == 1:
        length = 1 + measure_length(matrix, i, j - 1, length)

    if i < len(matrix) - 1 and matrix[i + 1][j] == 1:
        length = 1 + measure_length(matrix, i + 1, j, length)

    if i > 0 and matrix[i - 1][j] == 1:
        length = 1 + measure_length(matrix, i - 1, j, length)

    return length
