def count_negative(matrix):
    """
    *** 'Amazon' interview question ***
    Count the negative number of a matrix that presorted in rows and columns.
    Problem statement and more details: https://youtu.be/5dJSZLmDsxk
    """
    count = 0
    i = 0
    j = len(matrix)
    while j >= 0 and i < len(matrix):
        if matrix[i][j] < 0:
            count += j + 1
            i += 1
        else:
            j -= 1
    return count


if __name__ == '__main__':
    print(count_negative([[-3, -2, -1, 1],
                          [-2, 2, 3, 4],
                          [4, 5, 7, 8]]))

    print(count_negative([[-3, -2, -1, 1],
                          [-2, -2, 3, 4],
                          [-1, 5, 7, 8]]))
