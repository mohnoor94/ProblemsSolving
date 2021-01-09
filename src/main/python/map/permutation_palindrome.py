"""
Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome. ↴

You can assume the input string only contains lowercase letters.

Examples:
- "civic" should return True
- "ivicc" should return True
- "civil" should return False
- "livci" should return False

"But 'ivicc' isn't a palindrome!"
If you had this thought, read the question again carefully. We're asking if any permutation of the string is a
palindrome. Spend some extra time ensuring you fully understand the question before starting. Jumping in with a flawed
understanding of the problem doesn't look good in an interview.

***

https://www.interviewcake.com/question/python3/permutation-palindrome?course=fc1&section=hashing-and-hash-tables
"""

import unittest


def has_palindrome_permutation(string):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)

    n: number of characters in the string
    """
    unpaired_characters = set()

    for char in string:
        if char in unpaired_characters:
            unpaired_characters.remove(char)
        else:
            unpaired_characters.add(char)

    return len(unpaired_characters) <= 1


def has_palindrome_permutation_2(string):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)

    n: number of characters in the string
    """
    counter = {}

    for char in string:
        counter[char] = counter[char] + 1 if char in counter else 1

    odd_counts = sum([1 for count in counter.values() if count % 2 != 0])

    return odd_counts <= 1


# Tests

class Test(unittest.TestCase):

    def test_permutation_with_odd_number_of_chars(self):
        result = has_palindrome_permutation('aabcbcd')
        self.assertTrue(result)

    def test_permutation_with_even_number_of_chars(self):
        result = has_palindrome_permutation('aabccbdd')
        self.assertTrue(result)

    def test_no_permutation_with_odd_number_of_chars(self):
        result = has_palindrome_permutation('aabcd')
        self.assertFalse(result)

    def test_no_permutation_with_even_number_of_chars(self):
        result = has_palindrome_permutation('aabbcd')
        self.assertFalse(result)

    def test_empty_string(self):
        result = has_palindrome_permutation('')
        self.assertTrue(result)

    def test_one_character_string(self):
        result = has_palindrome_permutation('a')
        self.assertTrue(result)


if __name__ == '__main__':
    unittest.main(verbosity=2)
