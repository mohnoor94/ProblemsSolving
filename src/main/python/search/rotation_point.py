"""
I want to learn some big words so people think I'm smart.
I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know. I put
each word I didn't know at increasing indices in a huge list I created in memory. When I reached the end of the
dictionary, I started from the beginning and did the same thing until I reached the page I started at.

Now I have a list of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet,
reach the end, and then start from the beginning of the alphabet. In other words, this is an alphabetically ordered
list that has been "rotated." For example:

  words = [
    'ptolemaic',
    'retrograde',
    'supplant',
    'undulate',
    'xenoepist',
    'asymptote',  # <-- rotates here!
    'babka',
    'banoffee',
    'engender',
    'karpatka',
    'othellolagkage',
]

- Write a function for finding the index of the "rotation point," which is where I started working from the beginning
of the dictionary. This list is huge (there are lots of words I don't know) so we want to be efficient here.
- To keep things simple, you can assume all words are lowercase.

***

https://www.interviewcake.com/question/python3/find-rotation-point?course=fc1&section=sorting-searching-logarithms

"""

import unittest


def find_rotation_point(words):
    """
    Time: O(log N) or O(l * log N)
    Space: O(1)

    N: number of words
    l: length of longest string (it could be considered as O(1) and omitted)
    """

    def search(start, end):
        if start == end:
            return words[start]

        mid = (start + end) // 2

        if mid < end and words[mid + 1] < words[mid]:
            return mid + 1

        if mid > start and words[mid] < words[mid - 1]:
            return mid

        if words[mid] < words[end]:
            return search(start, mid - 1)

        return search(mid + 1, end)

    return search(0, len(words) - 1)


class Test(unittest.TestCase):

    def test_small_list(self):
        actual = find_rotation_point(['cape', 'cake'])
        expected = 1
        self.assertEqual(actual, expected)

    def test_medium_list(self):
        actual = find_rotation_point(['grape', 'orange', 'plum', 'radish', 'apple'])
        expected = 4
        self.assertEqual(actual, expected)

    def test_large_list(self):
        actual = find_rotation_point(['ptolemaic', 'retrograde', 'supplant',
                                      'undulate', 'xenoepist', 'asymptote',
                                      'babka', 'banoffee', 'engender',
                                      'karpatka', 'othellolagkage'])
        expected = 5
        self.assertEqual(actual, expected)


if __name__ == '__main__':
    unittest.main(verbosity=2)
