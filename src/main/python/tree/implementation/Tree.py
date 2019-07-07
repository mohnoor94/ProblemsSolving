from __future__ import annotations

from typing import Union

NullableNode = Union[None, None]


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

    def inorder_print(self):
        self.__inorder_print()
        print()

    def __inorder_print(self):
        if self.left:
            self.left.__inorder_print()

        print(f'{self.__str__()}, ', end='')

        if self.right:
            self.right.__inorder_print()

    def __str__(self) -> str:
        return f'< {self.data} >'
