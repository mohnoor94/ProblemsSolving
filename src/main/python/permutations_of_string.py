"""
    Given a small string s and a bigger string b, design an algorithm to find all permutations of the shorter string
    within the longer one. print the location of each permutation.

    - Cracking the coding interview, a book by Gayle Mcdowell. pg70
"""

from collections import Counter


def print_permutations(s, b):
    """
    Time:   O(b*s)
    Space:  O(s)
    """
    scounter = Counter()
    for c in s:
        scounter[c] += 1
    for i in range(len(b) - 3):
        wcounter = Counter()
        for c in b[i: i + 4]:
            wcounter[c] += 1
        if scounter[s[0]] == wcounter[s[0]] and scounter[s[1]] == wcounter[s[1]] \
                and scounter[s[2]] == wcounter[s[2]] and scounter[s[3]] == wcounter[s[3]]:
            print(b[i:i + 4], i, i + 4)


if __name__ == '__main__':
    print_permutations('abbc', 'cbabadcbbabbcbabaabccbabc')
