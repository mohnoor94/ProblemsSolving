package tree;

import tree.implementation.TreeNode;

/**
 * *** 'Amazon' interview question ***
 * ***
 * Given a complete binary tree, count the number of nodes in faster than O(n) time.
 * Recall that a complete binary tree has every level filled except the last, and the nodes in the last level are
 * filled starting from the left.
 */
public class CountNodes {
    /** light testing */
    public static void main(String[] args) {
        final TreeNode treeNode = new TreeNode(10, new TreeNode(5, new TreeNode(7), null), new TreeNode(20));
        treeNode.print();
        System.out.println(countNodes(treeNode));
    }

    /**
     * Time: O(lg N * lg N) = O ((lg N) ^ 2) ==> we calculate the height lg N times.
     * Space: O(lg N) ==> We save the counts in stack
     * -
     * N: Number of nodes
     */
    private static long countNodes(TreeNode treeNode) {
        if (treeNode == null) return 0;

        int leftHeight = getLeftHeight(treeNode);
        int rightHeight = getRightHeight(treeNode);

        if (leftHeight == rightHeight) return (long) Math.pow(2, leftHeight) - 1;

        return 1 + countNodes(treeNode.getLeft()) + countNodes(treeNode.getRight());
    }

    /**
     * Time: O(lg N)
     * Space: O(1)
     * -
     * N: Number of nodes
     */
    private static int getLeftHeight(TreeNode treeNode) {
        int height = 0;

        while (treeNode != null) {
            ++height;
            treeNode = treeNode.getLeft();
        }

        return height;
    }

    /**
     * Time: O(lg N)
     * Space: O(1)
     * -
     * N: Number of nodes
     */
    private static int getRightHeight(TreeNode treeNode) {
        int height = 0;

        while (treeNode != null) {
            ++height;
            treeNode = treeNode.getRight();
        }

        return height;
    }

}
