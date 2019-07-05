"""
*** 'Google' interview question ***
***

Problem statement: https://youtu.be/wyu6VRmtCmE
"""


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


def test(method):
    print('abc', 'ABC', '==>', method('abc', 'ABC'))
    print('abc', 'aBc', '==>', method('abc', 'aBc'))
    print('abc', 'aBd', '==>', method('abc', 'aBd'))
    print('abc', 'aBcd', '==>', method('abc', 'aBcd'))
    print('abDc', 'aBDd', '==>', method('abDc', 'aBDd'))
    print('abDc', 'aBD', '==>', method('abDc', 'aBD'))
    print("=" * 10)


if __name__ == '__main__':
    test(insensitive_compare1)
    test(insensitive_compare2)
    test(insensitive_compare3)

    print("=" * 10)
    print("=" * 10)

    print('abc', 'ABC', 2, '==>', insensitive_compare4('abc', 'ABC', 2))
    print('abc', 'aBc', 2, '==>', insensitive_compare4('abc', 'aBc', 2))
    print('abc', 'aBd', 2, '==>', insensitive_compare4('abc', 'aBd', 2))
    print('abc', 'aBcd', 2, '==>', insensitive_compare4('abc', 'aBcd', 2))
    print('abDc', 'aBDd', 2, '==>', insensitive_compare4('abDc', 'aBDd', 2))
    print('abDc', 'aBD', 2, '==>', insensitive_compare4('abDc', 'aBD', 2))
    print('abDc', 'aBD', 2, '==>', insensitive_compare4('abDc', 'aBD', 2))
    print('abc', 'ade', 2, '==>', insensitive_compare4('abc', 'ade', 2))
    print('abc', 'abcde', 2, '==>', insensitive_compare4('abc', 'abcde', 2))
    print('abc', 'abcdef', 2, '==>', insensitive_compare4('abc', 'abcdef', 2))
    print('abdec', 'abc', 2, '==>', insensitive_compare4('abdec', 'abc', 2))
    print('abdezc', 'abc', 2, '==>', insensitive_compare4('abdezc', 'abc', 2))
    print('abcde', 'abc', 2, '==>', insensitive_compare4('abcde', 'abc', 2))
    print('abcdef', 'abc', 3, '==>', insensitive_compare4('abcdef', 'abc', 3))
    print('abcdef', 'abc', 3, '==>', insensitive_compare4('abcdef', 'abc', 3))
    print('abcdef', 'abck', 3, '==>', insensitive_compare4('abcdef', 'abck', 3))
    print('abcdefjg', 'abck', 3, '==>', insensitive_compare4('abcdefjg', 'abck', 3))
    print('abcdefjg', 'abckek', 3, '==>', insensitive_compare4('abcdefjg', 'abckek', 3))
