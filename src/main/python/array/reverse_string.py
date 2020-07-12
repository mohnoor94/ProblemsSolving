"""
    Write a function that takes a list of characters and reverses the letters in place.

    > Why a list of characters instead of a string?
    The goal of this question is to practice manipulating strings in place. Since we're modifying the input, we need a
    mutable ↴ type like a list, instead of Python 3.6's immutable strings.

    - More Details: https://www.interviewcake.com/question/python3/reverse-string-in-place
"""
from src.main.python.util import utils


def reverse(characters):
    def swap(first, second):
        characters[first], characters[second] = characters[second], characters[first]

    length = len(characters)
    half_length = length // 2

    for index, ch in enumerate(characters[:half_length]):
        swap(index, length - 1 - index)


if __name__ == '__main__':
    a = []
    b = ['A']
    c = ['A', 'B', 'C', 'D', 'E']
    d = ['A', 'B', 'C', 'D', 'E', 'F']

    reverse(a)
    reverse(b)
    reverse(c)
    reverse(d)

    test_cases = [
        ('test_empty_string', [], a),
        ('test_single_character_string', ['A'], b),
        ('test_longer_string_odd_length', ['E', 'D', 'C', 'B', 'A'], c),
        ('test_longer_string_even_length', ['F', 'E', 'D', 'C', 'B', 'A'], d),
    ]

    print('all tests passed' if utils.test_all(test_cases) else 'something wrong, check cases above!')
