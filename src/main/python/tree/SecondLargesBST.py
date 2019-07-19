"""
    *** 'DropBox' interview question ***

    Given the root to a binary search tree, find the second largest node in the tree.
"""
from tree.implementation.Tree import NullableNode, Node


def second_largest(tree: NullableNode) -> int or None:
    """
    - Time: O(len(tree)))
    - Space: O(1) - In place
    """
    def helper(node: Node, largest_found: bool) -> int:
        if node.has_right():
            right = node.right
            if right.is_leaf():
                return right.data if largest_found else node.data
            if node.right.has_right():
                return helper(node.right, largest_found)

            return helper(right.left, True)
        elif node.has_left():
            left = node.left
            return left.data if left.is_leaf() or not left.has_right() else helper(left, True)

    return None if not tree or tree.is_leaf() else helper(tree, False)


if __name__ == '__main__':
    print(second_largest(None))
    print(second_largest(Node(5)))
    print(second_largest(Node(5).with_right(10)))
    print(second_largest(Node(5).with_right(10).with_left(2)))

    print('=' * 20)

    node1 = Node(6).with_left(4).with_right(7)
    node2 = Node(3).with_left(1).right_node(node1)
    node3 = Node(14).with_left(13)
    node4 = Node(10).right_node(node3)
    node5 = Node(8).left_node(node2).right_node(node4)

    node5.inorder_print()
    print(second_largest(node5))

    print('=' * 20)

    node6 = Node(13).with_right(15)
    node7 = Node(20).left_node(node6)
    node8 = Node(10).right_node(node7)
    node9 = Node(8).left_node(node2).right_node(node8)

    node9.inorder_print()
    print(second_largest(node9))

    print('=' * 20)

    node10 = Node(8).left_node(node2)

    node10.inorder_print()
    print(second_largest(node10))
