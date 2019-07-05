"""
*** 'Google' interview question ***
***

Given a list of meetings, and a total hours we can commit to.
Return a list of meetings that optimized to:
- largest number of meetings we can attend
- longest time of meeting hours we can attend

***
Problem Statement: https://youtu.be/Q5_2BCej9hg
"""

from typing import List, Callable


class Meeting:
    def __init__(self, title: str, hours: int):
        self.title = title
        self.hours = hours

    def __repr__(self):
        return f'<{self.title}, {self.hours}>'


def get_items(num, items) -> list:
    idx = [int(x) for x in bin(num)[2:]]
    idx.reverse()
    return list(map(lambda t: t[1], filter(lambda t: t[0], zip(idx, items))))


def get_possibilities(items):
    for i in range(2 ** len(items)):
        yield get_items(i, items)


def optimize_meetings_longest_time(meetings: List[Meeting], hours: int) -> List[Meeting]:
    answers = {}
    for ans in get_possibilities(meetings):
        summation = sum(map(lambda a: a.hours, ans))
        if summation == hours:
            return ans
        else:
            answers[summation] = ans

    for i in range(hours, 0, -1):
        if i in answers:
            return answers[i]


def optimize_meetings_largest_number(meetings: List[Meeting], hours: int) -> List[Meeting]:
    sorted_meetings = sorted(meetings, key=lambda _: _.hours)

    total = 0
    result = []

    for m in sorted_meetings:
        if total + m.hours <= hours:
            total += m.hours
            result.append(m)
        else:
            break

    return result


def test(title: str, method: Callable[[List[Meeting], int], List[Meeting]]) -> None:
    print(title, '\n')
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2)], 8))
    print(method([Meeting('a', 5), Meeting('b', 4), Meeting('c', 4)], 8))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2)], 5))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 2)], 9))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 1)], 9))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 3)], 9))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 3)], 90))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 3)], 3 ))
    print(method([Meeting('a', 5), Meeting('b', 3), Meeting('c', 2), Meeting('d', 3)], 1))
    print()
    print('=' * 25)


if __name__ == '__main__':
    test('Optimize by Longest Busy Time::', optimize_meetings_longest_time)
    test('Optimize By Largest Number of Meetings to Attend::', optimize_meetings_largest_number)
