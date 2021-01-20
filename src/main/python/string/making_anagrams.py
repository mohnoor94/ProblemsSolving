"""
 Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string.
 In other words, both strings must contain the same exact letters in the same exact frequency.

 For example,
    bacdc and dcbac are anagrams,
    but bacdc and dcbad are not.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character
deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

***

https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
"""


def count_letters(word):
    counter = {}

    for c in word:
        counter[c] = counter[c] + 1 if c in counter else 1

    return counter


def make_anagram(first, second):
    """
    Time: O(first + second)
    Space: O(first) ;

    first: length of the first word
    second: length of the second word

    Space could be enhanced to be the length of the shortest word, or better to save the counts in a list of 26 elements
    (# of letters in English) so that each element has the count of a letter in a corresponding index (-97)
    so we have a space of O(1).
    """
    first_letters = count_letters(first)
    similar_letters = 0

    for c in second:
        if c in first_letters and first_letters[c] > 0:
            similar_letters += 1
            first_letters[c] -= 1

    return len(first) + len(second) - 2 * similar_letters


if __name__ == '__main__':
    print(make_anagram("hello", "billion"))
