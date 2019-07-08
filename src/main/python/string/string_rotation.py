"""
    Assume you have a method isSubString which checks if one word is a substring of another.
    Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString.

    Example: 'waterbottle' is a rotation of 'erbottlewat'

    - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.9)
"""


def is_substr(str1, str2):
    """
    Given in the problem
    """
    return str1 in str2


def is_rotation_1(str1, str2):
    if len(str1) != len(str2):
        return False

    p1 = p2 = 0

    while str1[p1] != str2[p2]:
        p2 += 1

    while p2 < len(str2) and str1[p1] == str2[p2]:
        p1 += 1
        p2 += 1

    if p2 != len(str2):
        return False

    return is_substr(str1[p1:len(str1)], str2)


def is_rotation_2(str1, str2):
    if len(str1) != len(str2):
        return False

    return is_substr(str1, str2 + str2)


if __name__ == '__main__':
    print(is_rotation_1('waterbottle', 'erbottlewat'), is_rotation_2('waterbottle', 'erbottlewat'))
    print(is_rotation_1('waterbottle', 'bottlewater'), is_rotation_2('waterbottle', 'bottlewater'))
    print(is_rotation_1('waterbottle', 'arbottlewat'), is_rotation_2('waterbottle', 'arbottlewat'))
    print(is_rotation_1('waterbottle', 'erbottlewa'), is_rotation_2('waterbottle', 'erbottlewa'))
