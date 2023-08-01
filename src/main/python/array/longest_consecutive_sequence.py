# Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
# [1,3,4,5,5,2,5] ==> 3
# [1,3,5,2,9] ==> 1
# [-3,-2,0,1,2,3] ==> 3

# Tiktok / ByteDance Solution Engineer Interview Question

def find_longest_consecutive_sequence(nums):  # [-3,-2,0,1,2,3]
    """
    Time: O(n)
    Space: O(1)
    """
    if not nums:
        return 0

    length = len(nums)  # 6
    if length == 1:
        return 1

    result = 1  # 1, 2, 4
    counter = 1  # 1, 2, 1, 2, 3, 4

    for i, n in enumerate(nums):  # [-3,-2,0,1,2,3]
        if i < length and nums[i + 1] == n + 1:  # -2 == -3 + 1
            counter += 1
        else:
            result = max(result, counter)
            counter = 1

    return result  # 4
