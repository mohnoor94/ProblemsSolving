package tree;

import tree.implementation.TreeNodeWithParent;

/**
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.6)
 */
@SuppressWarnings("Duplicates")
public class SuccessorNode {

    public static void main(String[] args) {
        TreeNodeWithParent node1 = new TreeNodeWithParent(10);
        TreeNodeWithParent node2 = new TreeNodeWithParent(5);
        TreeNodeWithParent node3 = new TreeNodeWithParent(2);
        TreeNodeWithParent node4 = new TreeNodeWithParent(6);
        TreeNodeWithParent node5 = new TreeNodeWithParent(1);
        TreeNodeWithParent node6 = new TreeNodeWithParent(15);
        TreeNodeWithParent node7 = new TreeNodeWithParent(20);
        TreeNodeWithParent node8 = new TreeNodeWithParent(13);
        TreeNodeWithParent node9 = new TreeNodeWithParent(23);
        TreeNodeWithParent node10 = new TreeNodeWithParent(25);

        node1.setLeft(node2);
        node1.setRight(node6);
        node2.setLeft(node3);
        node2.setRight(node4);
        node3.setLeft(node5);
        node6.setRight(node7);
        node6.setLeft(node8);
        node7.setRight(node10);
        node10.setLeft(node9);

        System.out.print("In order traversal: ");
        node1.print();

        System.out.println(node1.getData() + " -> " + getSuccessor(node1));
        System.out.println(node2.getData() + " -> " + getSuccessor(node2));
        System.out.println(node3.getData() + " -> " + getSuccessor(node3));
        System.out.println(node4.getData() + " -> " + getSuccessor(node4));
        System.out.println(node5.getData() + " -> " + getSuccessor(node5));
        System.out.println(node6.getData() + " -> " + getSuccessor(node6));
        System.out.println(node7.getData() + " -> " + getSuccessor(node7));
        System.out.println(node8.getData() + " -> " + getSuccessor(node8));
        System.out.println(node9.getData() + " -> " + getSuccessor(node9));
        System.out.println(node10.getData() + " -> " + getSuccessor(node10));
    }

    private static TreeNodeWithParent getSuccessor(TreeNodeWithParent node) {
        if (node == null) return null;

        if (node.hasRight()) return node.getRight().getLeftMostChild().asTreeNodeWithParent();

        if (node.hasParent()) {
            TreeNodeWithParent parent = node.getParent();
            if (parent.getLeft() == node) return parent;

            TreeNodeWithParent parentOfParent = parent.getParent();
            if (parent.hasParent() && parentOfParent.getLeft() == parent) return parentOfParent;
        }

        return null;
    }
}
