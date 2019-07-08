from __future__ import annotations

from typing import Union


class Node:

    def __init__(self, data):
        self.data = data
        self.left: NullableNode = None
        self.right: NullableNode = None

    def with_left(self, data) -> Node:
        self.left = Node(data)
        return self

    def with_right(self, data) -> Node:
        self.right = Node(data)
        return self

    def left_node(self, left: Node) -> Node:
        self.left = left
        return self

    def right_node(self, right: Node) -> Node:
        self.right = right
        return self

    def has_left(self):
        return bool(self.left)

    def has_right(self):
        return bool(self.right)

    def is_full(self):
        return self.left and self.right

    def is_leaf(self):
        return not self.left and not self.right

    def not_leaf(self):
        return self.left or self.right

    def has_single_child(self):
        return self.has_left() and not self.has_right() or self.has_right() and not self.has_left()

    def child(self):
        if self.has_left():
            return self.left
        return self.right

    def inorder_print(self):
        self.__inorder_print()
        print()

    def __inorder_print(self):
        if self.left:
            self.left.__inorder_print()

        print(f'{self.__str__()}, ', end='')

        if self.right:
            self.right.__inorder_print()

    def __eq__(self, other):
        return self.data == other.data

    def __str__(self) -> str:
        return f'< {self.data} >'


NullableNode = Union[Node, None]
