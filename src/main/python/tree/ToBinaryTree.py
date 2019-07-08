"""
*** 'Yahoo' interview question ***

* Recall that a full binary tree is one in which each node is either a leaf node, or has two children. Given a binary
tree, convert it to a full one by removing nodes with only one child.

* For example, given the following tree:

                 0
              /     \
            1         2
          /            \
        3                 4
          \             /   \
            5          6     7

 -> You should convert it to:

                 0
              /     \
            5         4
                    /   \
                   6     7
"""
from tree.implementation.Tree import NullableNode, Node


def to_bst(root: NullableNode, parent: NullableNode = None) -> None:
    if not root:
        return None

    if root.is_full():
        to_bst(root.left, root)
        to_bst(root.right, root)
    elif root.has_single_child():
        child = root.child()
        if parent.left == root:
            parent.left = child
        else:
            parent.right = child
        to_bst(child, parent)


if __name__ == '__main__':
    node1 = Node(3).with_right(5)
    node2 = Node(4).with_left(6).with_right(7)
    node3 = Node(1).left_node(node1)
    node4 = Node(2).right_node(node2)
    head = Node(0).left_node(node3).right_node(node4)

    head.inorder_print()

    to_bst(head)

    head.inorder_print()
