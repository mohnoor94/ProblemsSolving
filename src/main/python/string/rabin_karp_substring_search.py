"""
    An algorithm used to search for a substring in a string.

    - Read more in: Cracking the coding interview, a book by Gayle Mcdowell (6th ed, pg636), or Google it.
"""

import math


def rabin_karp_search(sub, main):
    """
    Time:   O(len(main))
    Space:  O(1)
    * if we want to return the [matches] list below, space will have O(len(main)/len(sub)).

    If space is a problem (e.g., we won't use 1 additional list for some weird reason), we could return the index of
    first occurrence of the sub in main.
    """
    if len(sub) > len(main):
        return -1
    if sub == main:
        return 0
    if len(sub) == len(main):
        return -1
    size = len(sub)
    matches = []
    sub_hash = fingerprint(sub)
    base_hash = fingerprint(main[0:size])
    for i in range(size, len(main)):
        if base_hash == sub_hash:
            matches.append(i - size)
        base_hash = (base_hash - code(main[i - size]) * math.pow(128, size - 1)) * 128 + code(main[i])
    if base_hash == sub_hash:
        matches.append(len(main) - len(sub))
    return matches


def fingerprint(string):
    p = len(string) - 1
    h = 0
    for c in string:
        h += code(c) * math.pow(128, p)
        p -= 1
    return h


def code(char):
    return ord(char)


if __name__ == '__main__':
    print(rabin_karp_search('hi', 'hello'))
    print(rabin_karp_search('hi', 'hillo'))
    print(rabin_karp_search('hi', 'hillhio'))
    print(rabin_karp_search('hi', 'hi ll hio'))
    print(rabin_karp_search('hi', 'hillhiollalahi'))
