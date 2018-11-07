"""
  Assign Numbers in Minesweeper
  <p>
  Implement a function that assigns correct numbers in a field of Minesweeper, which is represented as a 2 dimensional
  array.
  
  Example:  The size of the field is 3x4, and there are bombs at the positions [0, 0] (row index = 0, column index = 0)
  and [0, 1] (row index = 0, column index = 1).
  Then, the resulting field should be:
  [[-1, -1, 1, 0],
  [2, 2, 1, 0],
  [0, 0, 0, 0]]
  
  Your function should return the resulting 2D array after taking the following three arguments:
  1- bombs: A list of bomb locations.  Given as an array of arrays.  Example: [[0, 0], [0, 1]] ([row index = 0,
  column index = 0], [row index = 0, column index = 1]. Assume that there are no duplicates.
  2- numRows: The number of rows in the resulting field.
  3- numCols: The number of columns in the resulting field.
  
  In the resulting array:
  -> -1 represents that there is a bomb in that location.
  -> 1, 2, 3... etc. represents that there are 1, 2, 3... etc. bombs in the surrounding cells (including diagonally
  adjacent cells).
  -> 0 represents that there are no bombs in the surrounding cells.
  
  - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""


def mine_sweeper(bombs, num_rows, num_cols):
    field = [[0 for i in range(num_cols)] for j in range(num_rows)]
    for bomb in bombs:
        (row, col) = bomb
        field[row][col] = -1
        for i in range(row - 1, row + 2):
            for j in range(col - 1, col + 2):
                if 0 >= i > num_rows and 0 >= j > num_cols and field[i][j] != -1:
                    field[i][j] += 1
    return field


# NOTE: Feel free to use the following function for testing.
# It converts a 2-dimensional array (a list of lists) into
# an easy-to-read string format.
def to_string(given_array):
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'


if __name__ == '__main__':
    print(to_string(mine_sweeper([[0, 2], [2, 0]], 3, 3)))
    print()
    print(to_string(mine_sweeper([[0, 0], [0, 1], [1, 2]], 3, 4)))
    print()
    print(to_string(mine_sweeper([[1, 1], [1, 2], [2, 2], [4, 3]], 5, 5)))
