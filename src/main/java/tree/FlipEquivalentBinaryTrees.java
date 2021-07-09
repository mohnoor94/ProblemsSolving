package tree;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child
 * subtrees.
 * <p>
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of
 * flip operations.
 * <p>
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false
 * otherwise.
 * ---
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class FlipEquivalentBinaryTrees {

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     * -
     * in every round, we may do up to 4 new calls: 4 ^ h = 4 ^ lg n = n ^ 2
     * -
     * n: number of nodes.
     * h: height of the tree (= lg n).
     * -
     * Tested on leetcode.
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        if (root1.val != root2.val) return false;

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
