"""
    *** 'Google' interview question ***

    The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
    For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
    You may also use a list or array to represent a set.
"""


def psets(s):
    """
    - Time: O(2^n)  <-- nature of the problem
    - Space: O(n)
    * n = len(s)
    """
    if not s:
        return [[]]

    result = []
    curr = s[0]
    child_ps = psets(s[1:])
    result.extend(child_ps)

    for child in child_ps:
        copy = child.copy()
        copy.append(curr)
        result.append(copy)

    return result


def print_solution(numbers):
    solution = psets(numbers)
    print(len(numbers), ',', len(solution), '-->', solution)


if __name__ == '__main__':
    print_solution([])
    print_solution([1])
    print_solution([1, 2])
    print_solution([1, 2, 3])
    print_solution([1, 2, 3, 4])
    print_solution([1, 2, 3, 4, 5])
