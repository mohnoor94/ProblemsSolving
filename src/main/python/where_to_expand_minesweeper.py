"""
    Find Where to Expand in Minesweeper

    Implement a function that turns revealed cells into -2 given a location the user wants to click.
    For simplicity, only reveal cells that have 0 in them.
    - If the user clicks on any other type of cell (for example, -1 / bomb or 1, 2, or 3), just ignore the click and
    return the original field.
    - If a user clicks 0, reveal all other 0's that are connected to it.

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""
import queue


def click_dfs(field, num_rows, num_cols, given_i, given_j):
    """
    Time:   O(num_rows * num_cols)
    Space:  O(num_rows * num_cols)
    """
    if 0 <= given_i < num_rows and 0 <= given_j < num_cols and field[given_i][given_j] == 0:
        field[given_i][given_j] = -2
    else:
        return field
    for i in range(given_i - 1, given_i + 2):
        for j in range(given_j - 1, given_j + 2):
            click_dfs(field, num_rows, num_cols, i, j)
    return field


def click_bfs(field, num_rows, num_cols, given_i, given_j):
    """
    Time:   O(num_rows * num_cols)
    Space:  O(num_rows + num_cols)
    """
    q = queue.Queue()
    if 0 <= given_i < num_rows and 0 <= given_j < num_cols and field[given_i][given_j] == 0:
        field[given_i][given_j] = -2
        q.put((given_i, given_j))
    while not q.empty():
        (row, col) = q.get()
        for i in range(row - 1, row + 2):
            for j in range(col - 1, col + 2):
                if 0 <= i < num_rows and 0 <= j < num_cols and field[i][j] == 0:
                    field[i][j] = -2
                    q.put((i, j))
    return field


def to_string(given_array):
    """
    Converts a 2-dimensional array (a list of lists) into an easy-to-read string format
    """
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'


if __name__ == '__main__':
    field1 = [[0, 0, 0, 0, 0],
              [0, 1, 1, 1, 0],
              [0, 1, -1, 1, 0]]
    field2 = [[-1, 1, 0, 0],
              [1, 1, 0, 0],
              [0, 0, 1, 1],
              [0, 0, 1, -1]]
    print(to_string(click_bfs(field1, 3, 5, 2, 2)))  # click_recursion is correct as well
    print()
    print(to_string(click_bfs(field1, 3, 5, 1, 4)))
    print()
    print(to_string(click_bfs(field2, 4, 4, 0, 1)))
    print()
    print(to_string(click_bfs(field2, 4, 4, 1, 3)))
