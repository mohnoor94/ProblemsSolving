"""
Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when
everyone is available.

To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as a tuple ↴ of
integers (start_time, end_time). These integers represent the number of 30-minute blocks past 9:00am.

For example:
    - (2, 3)  # Meeting from 10:00 – 10:30 am
    - (6, 9)  # Meeting from 12:00 – 1:30 pm

Write a function merge_ranges() that takes a list of multiple meeting time ranges and returns a list of condensed
ranges.

For example, given:
    - [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
    - your function would return: [(0, 1), (3, 8), (9, 12)]

Do not assume the meetings are in order. The meeting times are coming from multiple teams.

Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.
Here we've simplified our times down to the number of 30-minute slots past 9:00 am. But we want the function to work
even for very large numbers, like Unix timestamps. In any case, the spirit of the challenge is to merge meetings where
start_time and end_time don't have an upper bound.

Problem Statement: https://www.interviewcake.com/question/python3/merging-ranges
"""
from typing import List, Tuple


def merge_meetings(meetings: List[Tuple[int, int]]) -> List[Tuple[int, int]]:
    """
    - Time: O(n log n); for sorting
    - Space: O(n)
    * n = len(meetings)
    """
    if len(meetings) == 0:
        return meetings

    def merge(first: Tuple[int, int], second: Tuple[int, int]) -> Tuple[int, int]:
        return first[0], max(first[1], second[1])

    def overlaps(first: Tuple[int, int], second: Tuple[int, int]) -> bool:
        return first[1] >= second[0]

    sorted_meetings = sorted(meetings, key=lambda m: m[0])
    answer = [sorted_meetings[0]]

    for i in range(1, len(meetings)):
        if overlaps(sorted_meetings[i - 1], sorted_meetings[i]):
            answer[-1] = (merge(sorted_meetings[i - 1], sorted_meetings[i]))
        else:
            answer.append(sorted_meetings[i])

    return answer


if __name__ == '__main__':
    print(merge_meetings([(1, 3), (2, 4)]))
    print(merge_meetings([(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]))
    print(merge_meetings([(0, 4), (6, 7), (8, 9), (12, 15)]))
    print(merge_meetings([(0, 4)]))
    print(merge_meetings([]))
