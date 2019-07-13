package tree;

import tree.implementation.TreeNode;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
 * tree with minimal height.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.2)
 */
public class MinimalTree {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9, 12};
        int[] array2 = {1, 2, 4, 6, 9, 12, 15};
        int[] array3 = {5};

        TreeNode treeNode1 = buildMinimalBinarySearchTree(array1);
        TreeNode treeNode2 = buildMinimalBinarySearchTree(array2);
        TreeNode treeNode3 = buildMinimalBinarySearchTree(array3);

        treeNode1.print();
        treeNode2.print();
        treeNode3.print();
    }

    /**
     * Time:    O(n);   n: size of the array
     * Space:   O(n)
     */
    private static TreeNode buildMinimalBinarySearchTree(int[] array) {
        return getMiddleTreeNode(array, 0, array.length - 1);
    }

    private static TreeNode getMiddleTreeNode(int[] array, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(array[mid]);
        node.setLeft(getMiddleTreeNode(array, start, mid - 1));
        node.setRight(getMiddleTreeNode(array, mid + 1, end));

        return node;
    }
}
