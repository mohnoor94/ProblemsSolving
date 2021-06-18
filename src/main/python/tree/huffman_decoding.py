"""
You are given pointer to the root of the Huffman tree and a binary coded string to decode. You need to print the decoded
string.

Full details: https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
"""


class Node:
    def __init__(self, freq, data):
        self.freq = freq
        self.data = data
        self.left = None
        self.right = None


def decode_huff(root, s):
    """
    Time: O(n)
    Space: O(n)
    -
    n: string length
    -
    Tested on hackerrank.
    """
    word = ""
    node = root

    for ch in s:
        if ch == "0":
            node = node.left
        else:
            node = node.right

        if not node.left and not node.right:
            word += node.data
            node = root

    print(word)
