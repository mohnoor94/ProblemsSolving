"""
    Write an algorithm  such that if an element in an M*N matrix is 0, its entire row anc column are set to 0.

    - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.8)
"""


def set_zeros(matrix):
    """
    Time:   O(n*m), n and m are the size of the matrix
    Space:  O(n), could be reduced to O(1) by checking the first row and first column first if they have any zeros,
            then use them to store the cols and rows arrays (or sets).
    """
    cols, rows = get_zero_positions(matrix)

    for i in rows:
        nullify_row(i, matrix)

    for j in cols:
        nullify_col(j, matrix)


def get_zero_positions(matrix):
    rows = set()
    cols = set()
    for i in range(0, len(matrix)):
        for j in range(0, len(matrix[i])):
            if matrix[i][j] == 0:
                rows.add(i)
                cols.add(j)
    return cols, rows


def nullify_row(row, matrix):
    for j in range(0, len(matrix[row])):
        matrix[row][j] = 0


def nullify_col(col, matrix):
    for i in range(0, len(matrix)):
        matrix[i][col] = 0


if __name__ == '__main__':
    m1 = [[1, 2, 3], [4, 0, 6], [7, 8, 9]]
    m2 = [[1, 0, 3], [4, 5, 6], [7, 8, 9]]
    m3 = [[1, 2], [3, 4], [5, 0]]
    set_zeros(m1)
    set_zeros(m2)
    set_zeros(m3)

    print(m1)
    print(m2)
    print(m3)
