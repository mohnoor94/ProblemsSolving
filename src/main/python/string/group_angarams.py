"""
Given an array of strings, group anagrams together.

Example:
    - Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    - Output:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]

Notes:
    - All inputs will be in lowercase.
    - The order of your output does not matter.

Problem Statement: https://leetcode.com/problems/group-anagrams/
"""
import collections
from typing import List


def group_anagrams(strings: List[str]):
    """
    :type strings: List[str]
    :rtype: List[List[str]]
    """
    answer = collections.defaultdict(list)

    a = ord('a')

    for s in strings:
        count = [0] * 26
        for c in s:
            count[ord(c) - a] += 1
        answer[tuple(count)].append(s)

    return answer.values()


if __name__ == '__main__':
    print(group_anagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
