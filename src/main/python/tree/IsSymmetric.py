"""
*** 'Amazon' interview question ***

Write a function that checks if a tree is symmetric/mirrored.
"""
from tree.implementation.Tree import Node


def is_symmetric(tree: Node) -> bool:
    def is_mirrored(left: Node, right: Node):
        if not left or not right:
            return not left and not right
        return left.data == right.data and is_mirrored(left.right, right.left) and is_mirrored(right.right, left.left)

    if not tree:
        return True

    return is_mirrored(tree.left, tree.right)


if __name__ == '__main__':
    print(is_symmetric(Node(10)))
    print()

    tree1 = Node(10).with_left(15).with_right(15)
    print(is_symmetric(tree1))
    print()

    tree2 = Node(10).with_left(20).with_right(30)
    print(is_symmetric(tree2))
    print()

    left1 = Node(30).with_left(40).with_right(60)
    right1 = Node(30).with_left(60).with_right(40)

    print(is_symmetric(Node(10).with_right(100)))
    print(is_symmetric(Node(10).with_left(100)))
    print()

    print(is_symmetric(Node(100).left_node(left1).right_node(right1)))
    print(is_symmetric(Node(100).left_node(right1).right_node(left1)))
    print(is_symmetric(Node(100).left_node(right1).right_node(right1)))
    print(is_symmetric(Node(100).left_node(left1).right_node(left1)))
    print()
