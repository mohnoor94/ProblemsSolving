"""
    Non-Repeating Character
    Implement a function that takes a string and returns the first If there is no non-repeating character, return None.
    Example (1): "abacc" -> 'b' ('a' appears twice, and so does 'c')
    Example (2): "xxyzx" -> 'y' ('y' and 'z' are non-repeating characters, and 'y' appears first)

    - More details: https://www.udemy.com/11-essential-coding-interview-questions/
"""
from collections import Counter


def non_repeating(string):
    counter = Counter()
    for c in string:
        counter[c] += 1
    for c in string:
        if counter[c] == 1:
            return c
    return None


if __name__ == "__main__":
    print(non_repeating("abcab"))
    print(non_repeating("abab"))
    print(non_repeating("aabbbc"))
    print(non_repeating("aabbdbc"))
