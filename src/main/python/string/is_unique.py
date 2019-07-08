"""
    Implement an algorithm to determine if a string has all unique characters.

    - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 1.1)
"""


def is_unique(string):
    shown = set()
    for c in string:
        if c in shown:
            return False
        else:
            shown.add(c)
    return True


if __name__ == '__main__':
    print(is_unique('hello'))
    print(is_unique('world'))
    print(is_unique('hello world'))
    print(is_unique('hi world'))
