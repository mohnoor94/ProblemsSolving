"""
Hom many non-empty universal value tree?

Problem Statement: https://youtu.be/7HgsS8bRvjo
"""
from typing import Tuple

from tree.implementation.Tree import NullableNode, Node


def count_nonempty_universal(head: NullableNode) -> int:
    """
    Count Non-Empty Universal Tree

    - Time: O(n) : n = number of nodes
    - Space: O(1)
    """

    def count_ne_unival(node: NullableNode) -> Tuple[int, bool]:
        if not node:
            return 0, True

        if node.is_leaf():
            return 1, True

        left_count, is_left_unival = count_ne_unival(node.left)
        right_count, is_right_unival = count_ne_unival(node.right)

        if is_left_unival and is_right_unival and (
                node == node.left == node.right
                or node == node.left and not node.right
                or node == node.right and not node.left
        ):
            return 1 + left_count + right_count, True
        return left_count + right_count, False

    return count_ne_unival(head)[0]


if __name__ == '__main__':
    node1 = Node(1).with_left(1).with_right(1)
    node2 = Node(1)
    node3 = Node(0).left_node(node1).with_right(0)
    node4 = Node(0).left_node(node2).right_node(node3)
    print(count_nonempty_universal(node4), 'should be 5')

    print(count_nonempty_universal(Node(1)), 'should be 1')

    print(count_nonempty_universal(Node(1).with_left(1).with_right(2)), 'should be 2')
    print(count_nonempty_universal(Node(1).with_left(2).with_right(2)), 'should be 2')
    print(count_nonempty_universal(Node(2).with_left(2).with_right(2)), 'should be 3')

    node5 = Node(1).with_left(1).with_right(1)
    node6 = Node(1).left_node(node5).with_right(1)
    node7 = Node(0).left_node(node6).with_right(0)
    node8 = Node(0).with_left(1).right_node(node7)

    print(count_nonempty_universal(node8), 'should be 7')

    node_right_left1 = Node(1, Node(1), Node(1))
    node_right1 = Node(0, node_right_left1, Node(0))
    tree1 = Node(0, Node(1), node_right1)

    node_right_right2 = Node(4, None, Node(4))
    node_right2 = Node(4, Node(4), node_right_right2)
    tree2 = Node(3, Node(2), node_right2)

    node_right_right3 = Node(3, None, Node(2))
    node_right3 = Node(3, Node(3), node_right_right3)
    tree3 = Node(3, Node(3), node_right3)

    print(count_nonempty_universal(tree1), 'should be 5')
    print(count_nonempty_universal(tree2), 'should be 5')
    print(count_nonempty_universal(tree3), 'should be 3')
    print(count_nonempty_universal(None), 'should be 0')
