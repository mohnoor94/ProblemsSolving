"""
*** 'Google' interview question ***
***

Problem statement: https://youtu.be/wyu6VRmtCmE
"""
from typing import Callable


def insensitive_compare1(s1: str, s2: str) -> bool:
    """
    - Time Complexity: O(len(s1))  # len(s1) = len(s2)
    - Space Complexity: O(len(s))  # strings are immutable
    """
    return s1.upper() == s2.upper()


def insensitive_compare2(s1: str, s2: str) -> bool:
    """
    Assume that the strings will be mostly unequal

    - Time Complexity: worst: O(len(s1)) / best O(1)
    - Space Complexity: best & worst: O(1)
    """
    if len(s1) != len(s2):
        return False

    for i in range(len(s1)):
        if s1[i].upper() != s2[i].upper():
            return False

    return True


def insensitive_compare3(s1: str, s2: str) -> bool:
    """
    ==> Same as `One Away Strings` problem that I solved before

    Assume strings are equal if the edit distance is <= 1
    Edits: Add, Remove, Update

    - Time Complexity: O(longest of len(s1) & len(s2))
    - Space Complexity: O(1)
    """
    len1 = len(s1)
    len2 = len(s2)

    if abs(len1 - len2) > 1:
        return False

    if len1 == len2:
        diff = False
        for i in range(len1):
            if s1[i].upper() != s2[i].upper():
                if diff:
                    return False
                else:
                    diff = True
    else:
        long, short = (s1, s2) if len1 > len2 else (s2, s1)
        for i in range(len(short)):
            sc = short[i].upper()
            if long[i].upper() != sc:
                if long[i + 1].upper() != sc:
                    return False

    return True


def insensitive_compare4(s1: str, s2: str, distance: int) -> bool:
    """
    Assume strings are equal if the edit distance is <= distance
    Edits: Add, Remove, Update

    - Time Complexity: O(longest of len(s1) & len(s2))
    - Space Complexity: O(1)
    """
    len1 = len(s1)
    len2 = len(s2)

    if abs(len1 - len2) > distance:
        return False

    diff = 0

    if len1 == len2:
        for i in range(len1):
            if s1[i].upper() != s2[i].upper():
                if diff > distance:
                    return False
                else:
                    diff += 1
    else:
        long, short = (s1, s2) if len1 > len2 else (s2, s1)
        for i in range(len(short)):
            sc = short[i].upper()
            if long[i].upper() != sc:
                diff += 1
                for j in range(1, distance):
                    if long[i + j].upper() != sc:
                        if diff > distance:
                            return False
                        else:
                            diff += 1

    return True


def test(func: Callable[[str, str], bool]) -> None:
    print('abc', 'ABC', '==>', func('abc', 'ABC'))
    print('abc', 'aBc', '==>', func('abc', 'aBc'))
    print('abc', 'aBd', '==>', func('abc', 'aBd'))
    print('abc', 'aBcd', '==>', func('abc', 'aBcd'))
    print('abDc', 'aBDd', '==>', func('abDc', 'aBDd'))
    print('abDc', 'aBD', '==>', func('abDc', 'aBD'))
    print("=" * 10)


def test4(str1: str, str2: str, distance: int) -> None:
    print(str1, str2, distance, '==>', insensitive_compare4(str1, str2, distance))


if __name__ == '__main__':
    test(insensitive_compare1)
    test(insensitive_compare2)
    test(insensitive_compare3)

    print("=" * 10)
    print("=" * 10)

    test4('abc', 'ABC', 2)
    test4('abc', 'aBc', 2)
    test4('abc', 'aBd', 2)
    test4('abc', 'aBcd', 2)
    test4('abDc', 'aBDd', 2)
    test4('abDc', 'aBD', 2)
    test4('abDc', 'aBD', 2)
    test4('abc', 'ade', 2)
    test4('abc', 'abcde', 2)
    test4('abc', 'abcdef', 2)
    test4('abdec', 'abc', 2)
    test4('abdezc', 'abc', 2)
    test4('abcde', 'abc', 2)
    test4('abcdef', 'abc', 3)
    test4('abcdef', 'abc', 3)
    test4('abcdef', 'abck', 3)
    test4('abcdefjg', 'abck', 3, )
    test4('abcdefjg', 'abckek', 3)
