from typing import List

"""
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines,
which, together with the x-axis forms a container, such that the container contains the most water.
* Notice that you may not slant the container.
***
https://leetcode.com/problems/container-with-most-water/
"""


def max_area(height: List[int]) -> int:
    """
    Time: O(n)
    Space: O(1)
    -
    n: size of the input list
    """
    fp = 0
    bp = len(height) - 1
    result = 0

    while bp > fp:
        left_height = height[fp]
        right_height = height[bp]
        area = min(left_height, right_height) * (bp - fp)
        result = max(result, area)

        if left_height < right_height:
            fp += 1
        elif right_height < left_height:
            bp -= 1
        else:
            fp += 1
            bp -= 1

    return result


if __name__ == '__main__':
    # light testing, tested on leetcode
    print(49 == max_area([1, 8, 6, 2, 5, 4, 8, 3, 7]))
