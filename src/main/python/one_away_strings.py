"""
    One Away Strings
    Write a function that takes two strings and returns True if they are one away from each other.
    They are one away from each other if a single operation (changing a character, deleting a character or adding a
    character) will change one of the strings to the other.

    Example (1): "abcde" and "abcd" are one away (deleting a character).
    Example (2): "a" and "a" are one away (changing the only character 'a' to the equivalent character 'a').
    Example (3): "abc" and "bcc" are NOT one away. (They are two operations away.)

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""


def is_one_away(s1, s2):
    longer = s1
    shorter = s2
    if len(s2) > len(s1):
        longer = s2
        shorter = s1
    if len(longer) - len(shorter) > 1:
        return False

    i = j = 0
    differences = 0
    while i < len(shorter):
        if shorter[i] != longer[j]:
            if differences > 0:
                return False
            differences += 1
            if len(shorter) < len(longer):
                j += 1
                continue
        i += 1
        j += 1
    return differences < 2


if __name__ == '__main__':
    print(is_one_away("abcde", "abcd"))  # should return True
    print(is_one_away("abde", "abcde"))  # should return True
    print(is_one_away("a", "a"))  # should return True
    print(is_one_away("abcdef", "abqdef"))  # should return True
    print(is_one_away("abcdef", "abccef"))  # should return True
    print(is_one_away("abcdef", "abcde"))  # should return True
    print(is_one_away("aaa", "abc"))  # should return False
    print(is_one_away("abcde", "abc"))  # should return False
    print(is_one_away("abc", "abcde"))  # should return False
    print(is_one_away("abc", "bcc"))  # should return False
