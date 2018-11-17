"""
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word that is the same forwards and backwards.
    A permutation is a rearrangement of letters.
    A palindrome does not need to be limited to just a dictionary words.

    Example:
        Input:  Tact Coa
        Output: True (permutations: "taco cat", "atco cta", etc.)

    - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.4)
"""

from collections import Counter


def is_palindrome_permutation(string):
    counter = Counter()

    for c in string:
        lower_char = c.lower()
        if 'a' <= lower_char <= 'z':
            counter[lower_char] += 1

    found_odd = False

    for k in counter:
        if counter[k] % 2 != 0:
            if found_odd:
                return False
            found_odd = True
    return True


if __name__ == '__main__':
    print(is_palindrome_permutation('Tact Coa'))
    print(is_palindrome_permutation('hello'))
    print(is_palindrome_permutation('hey'))
    print(is_palindrome_permutation('huh'))
