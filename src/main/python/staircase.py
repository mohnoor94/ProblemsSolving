def number_of_ways(n):
    """
    *** 'Amazon' interview question ***
    Staircase problem with allowed steps of only 1 or 2 at a time.
    Problem statement and more details: https://youtu.be/5o-kdjv7FD0
    """
    if n == 0 or n == 1:
        return 1

    result = s1 = s2 = 1
    for i in range(2, n + 1):
        result = s1 + s2
        s1 = s2
        s2 = result

    return result


def number_of_ways_general(n, steps):
    """
    *** 'Amazon' interview question ***
    Staircase problem with allowed steps given in a set.
    Problem statement and more details: https://youtu.be/5o-kdjv7FD0
    """
    if n == 0:
        return 1

    nums = [0] * (n + 1)
    nums[0] = 1

    for i in range(1, n + 1):
        total = 0
        for j in steps:
            if i - j >= 0:
                total += nums[i - j]
        nums[i] = total

    return nums[n]


if __name__ == '__main__':
    print(0, "==>", number_of_ways(0))
    print(1, "==>", number_of_ways(1))
    print(2, "==>", number_of_ways(2))
    print(3, "==>", number_of_ways(3))
    print(4, "==>", number_of_ways(4))
    print(5, "==>", number_of_ways(5))
    print(6, "==>", number_of_ways(6))
    print(7, "==>", number_of_ways(7))
    print("********************")
    print(0, ",", {1, 2}, "==>", number_of_ways_general(0, {1, 2}))
    print(1, ",", {1, 2}, "==>", number_of_ways_general(1, {1, 2}))
    print(2, ",", {1, 2}, "==>", number_of_ways_general(2, {1, 2}))
    print(3, ",", {1, 2}, "==>", number_of_ways_general(3, {1, 2}))
    print(4, ",", {1, 2}, "==>", number_of_ways_general(4, {1, 2}))
    print(5, ",", {1, 2}, "==>", number_of_ways_general(5, {1, 2}))
    print(6, ",", {1, 2}, "==>", number_of_ways_general(6, {1, 2}))
    print(7, ",", {1, 2}, "==>", number_of_ways_general(7, {1, 2}))
    print("********************")
    print(0, ",", {1, 2, 5}, "==>", number_of_ways_general(0, {1, 2, 5}))
    print(1, ",", {1, 2, 5}, "==>", number_of_ways_general(1, {1, 2, 5}))
    print(2, ",", {1, 2, 5}, "==>", number_of_ways_general(2, {1, 2, 5}))
    print(3, ",", {1, 2, 5}, "==>", number_of_ways_general(3, {1, 2, 5}))
    print(4, ",", {1, 2, 5}, "==>", number_of_ways_general(4, {1, 2, 5}))
    print(5, ",", {1, 2, 5}, "==>", number_of_ways_general(5, {1, 2, 5}))
    print(6, ",", {1, 2, 5}, "==>", number_of_ways_general(6, {1, 2, 5}))
    print(7, ",", {1, 2, 5}, "==>", number_of_ways_general(7, {1, 2, 5}))
    print("********************")
    print(0, ",", {1, 3, 5}, "==>", number_of_ways_general(0, {1, 3, 5}))
    print(1, ",", {1, 3, 5}, "==>", number_of_ways_general(1, {1, 3, 5}))
    print(2, ",", {1, 3, 5}, "==>", number_of_ways_general(2, {1, 3, 5}))
    print(3, ",", {1, 3, 5}, "==>", number_of_ways_general(3, {1, 3, 5}))
    print(4, ",", {1, 3, 5}, "==>", number_of_ways_general(4, {1, 3, 5}))
    print(5, ",", {1, 3, 5}, "==>", number_of_ways_general(5, {1, 3, 5}))
    print(6, ",", {1, 3, 5}, "==>", number_of_ways_general(6, {1, 3, 5}))
    print(7, ",", {1, 3, 5}, "==>", number_of_ways_general(7, {1, 3, 5}))
    print("********************")
