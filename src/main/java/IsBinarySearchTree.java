/**
 * Is This a Binary Search Tree?
 * Write a function that takes a binary tree and returns true if it is a binary search tree and false if not.
 *
 * - More details: https://www.udemy.com/11-essential-coding-interview-questions/
 */
public class IsBinarySearchTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(0, new TreeNode(1, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(2, new TreeNode(5, null, null), new TreeNode(6, null, null)));
        System.out.println(isBST(tree1));

        TreeNode tree2 = new TreeNode(3, new TreeNode(1, new TreeNode(0, null, null), new TreeNode(2, null, null)),
                new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, null, null)));
        System.out.println(isBST(tree2));
    }

    public static boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.value < min || node.value > max) return false;

        return isBST(node.left, min, node.value) && isBST(node.right, node.value, max);
    }
}
