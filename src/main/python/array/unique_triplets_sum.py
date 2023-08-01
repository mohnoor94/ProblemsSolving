# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

# [1,2,3,5,5] => False
# [1,2,-3,5] => True
# [1,2,-4,5] => False

# Tiktok / ByteDance Solution Engineer Interview Question

# This solution will find *if* there are any triplets that sum to 0, but not the actual triplets.

def is_triplet_equal_zero(nums):
    for i, n in enumerate(nums):
        goal = -1 * n  # -1, -2
        if is_summation_goal(nums[i + 1:], goal):
            return True

    return False


def is_summation_goal(nums, goal):  # 2,-4,5, -1
    visited = set()  # 2, -4, 5

    for n in nums:  # 2, -4, 5
        if visited.has(goal - n):  # -1 --4 ==> 3 || -1 -5 = -6
            return True
        else:
            visited.add(n)

    return False
