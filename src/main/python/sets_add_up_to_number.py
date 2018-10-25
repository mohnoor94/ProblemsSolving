def count_sets(array, total):
    """
    *** Interview question ***
    > Dynamic Programming <

    A generalization of 'IsSummationFound' problem
    BUT:
        - No duplicates
        - No negative numbers
        - Array is sorted

    Problem statement and more details: https://youtu.be/nqlNzOcnCfs

    Note: I think there is something not 100% correct here... TODO: Review this solution again!
    """
    return rec_count_sets(array, total, len(array) - 1, {})


def rec_count_sets(array, total, i, memo):
    key = str(i) + '@' + str(total)
    if key in memo:
        return memo[key]

    if total == 0:
        return 1

    if total < 0 or i < 0:
        return 0

    if total < array[i]:
        result = rec_count_sets(array, total, i - 1, memo)
    else:
        result = rec_count_sets(array, total, i - 1, memo) + rec_count_sets(array, total - array[i], i - 1, memo)

    memo[key] = result
    return result


if __name__ == '__main__':
    print(count_sets([2, 4, 6, 10], 6))
    print(count_sets([1, 10, 15, 20, 25, 50, 100, 200, 1000], 100))
    print(count_sets([1, 2, 3], 10))
    print(count_sets([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 9))
    print(count_sets([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 10))
