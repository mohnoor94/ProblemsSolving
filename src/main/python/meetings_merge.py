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
    meetings_length = len(meetings)
    if meetings_length == 0 or meetings_length == 1:
        return meetings

    def merge(first: Tuple[int, int], second: Tuple[int, int]) -> Tuple[int, int]:
        return first[0], max(first[1], second[1])

    def overlaps(first: Tuple[int, int], second: Tuple[int, int]) -> bool:
        return second[0] <= first[1]

    sorted_meetings = sorted(meetings)  # O(n log n)
    answer = [sorted_meetings[0]]

    for current_meeting in sorted_meetings[1:]:  # O(n)
        last_merged_meeting = answer[-1]

        if overlaps(last_merged_meeting, current_meeting):
            answer[-1] = merge(last_merged_meeting, current_meeting)
        else:
            answer.append(current_meeting)

    return answer


def test_solution():
    test_cases = [
        ('test_meetings_overlap', [(1, 4)], merge_meetings([(1, 3), (2, 4)])),
        ('test_meetings_touch', [(5, 8)], merge_meetings([(5, 6), (6, 8)])),
        ('test_meeting_contains_other_meeting', [(1, 8)], merge_meetings([(1, 8), (2, 5)])),
        ('test_meetings_stay_separate', [(1, 3), (4, 8)], merge_meetings([(1, 3), (4, 8)])),
        ('test_multiple_merged_meetings', [(1, 8)], merge_meetings(([(1, 4), (2, 5), (5, 8)]))),
        ('test_meetings_not_sorted', [(1, 4), (5, 8)], merge_meetings([(5, 8), (1, 4), (6, 8)])),
        ('test_one_long_meeting_contains_smaller_meetings', [(1, 12)],
         merge_meetings([(1, 10), (2, 5), (6, 8), (9, 10), (10, 12)])),
        ('test_sample_input', [(0, 1), (3, 8), (9, 12)], merge_meetings([(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)])),
        ('additional_test_1', [(0, 1), (3, 8), (9, 12)], merge_meetings([(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)])),
        ('additional_test_2', [(0, 4), (6, 7), (8, 9), (12, 15)], merge_meetings([(0, 4), (6, 7), (8, 9), (12, 15)])),
        ('additional_test_3', [(0, 4)], merge_meetings([(0, 4)])),
        ('additional_test_4', [(1, 10)], merge_meetings([(1, 10), (2, 6), (3, 5), (7, 9)])),
        ('empty_meetings_list', [], merge_meetings([])),
    ]

    all_passed = True

    for test_title, expected, actual in test_cases:
        if actual != expected:
            print(f"TEST FAILED -> '{test_title}':: actual: {actual} != expected: {expected}")
            all_passed = False

    return all_passed


if __name__ == '__main__':
    print('all tests passed' if test_solution() else 'something wrong, check cases above!')
