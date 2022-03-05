"""
The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
Complete the height function which must return the height of a binary tree as an integer.

https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/
"""


class Node:
    def __init__(self, info, left=None, right=None):
        self.info = info
        self.left = left
        self.right = right


def height(root, level=-1):
    """
    Time: O(n)
    Space: O(n)
    -
    n: number of nodes
    """
    if not root:
        return level

    return max(height(root.left, level + 1), height(root.right, level + 1))


if __name__ == '__main__':
    # light testing, tested on hackerrank.
    print(height(Node(3, Node(2, Node(1)), Node(5, Node(4), Node(6, Node(7))))) == 3)
    print(height(Node(15)) == 0)
    print(height(Node(3, Node(1), Node(7, Node(5, Node(4))))) == 3)
