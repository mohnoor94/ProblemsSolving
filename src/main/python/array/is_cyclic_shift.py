"""
For two arrays a and b of the same length, let's say a is a cyclic shift of b, if it's possible for a to become equal
to b by performing cyclic shift operations on a - moving 0 or more elements from the beginning of the array to the end
of the array without changing the order of the elements.

You are given an array of integers elements.
Your task is to check whether elements is a cyclic shift of the sorted array [1, 2, ..., elements.length].
Return the number of elements you need to move to make elements equal to the sorted array. If elements is not a cyclic
shift of the sorted array (it's not possible to make them equal), return -1.

***
https://app.codesignal.com/live-interview/Lw9Wxrua3xbGXXzXA
***
*** 'Vectra.ai' interview question ***
"""


def solution(elements):
    i = 0
    break_index = -1

    while i + 1 < len(elements) and elements[i + 1] >= elements[i]:
        i += 1
    else:
        break_index = i

    if break_index == len(elements) - 1:
        return 0

    if elements[break_index + 1:] != list(range(1, len(elements) - break_index)):
        return -1

    return break_index + 1
