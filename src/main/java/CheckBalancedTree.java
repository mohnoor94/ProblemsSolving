import util.tree.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced.
 * A balanced tree is a defined to be a tree such that the heights of two subtrees of any node never differ by
 * more than one.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.4)
 */
@SuppressWarnings("Duplicates")
public class CheckBalancedTree {

    public static void main(String[] args) {
        CheckBalancedTree solution = new CheckBalancedTree();

        TreeNode balancedTree = solution.getBalancedTree();
        TreeNode perfectTree = solution.getPerfectTree();
        TreeNode unBalancedTree = solution.getUnBalancedTree();
        TreeNode anotherUnBalancedTree = solution.getAnotherUnBalancedTree();

        System.out.println(solution.isBalanced1(perfectTree));
        System.out.println(solution.isBalanced1(balancedTree));
        System.out.println(solution.isBalanced1(unBalancedTree));
        System.out.println(solution.isBalanced1(anotherUnBalancedTree));

        System.out.println();

        System.out.println(solution.isBalanced2(perfectTree));
        System.out.println(solution.isBalanced2(balancedTree));
        System.out.println(solution.isBalanced2(unBalancedTree));
        System.out.println(solution.isBalanced2(anotherUnBalancedTree));
    }

    private boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return -1;

        int leftHeight = checkHeight(node.getLeft());
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.getRight());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean isBalanced1(TreeNode node) {
        if (node == null || node.isLeaf()) return true;

        boolean leafFound = (node.hasLeft() && node.getLeft().isLeaf()) || (node.hasRight() && node.getRight().isLeaf());
        return isBalanced1(node.getLeft(), leafFound) && isBalanced1(node.getRight(), leafFound);
    }

    private boolean isBalanced1(TreeNode node, boolean leafFound) {
        if (node == null || node.isLeaf()) return true;

        if (leafFound && (node.hasLeft() && node.getLeft().hasChildren() || node.hasRight() && node.getRight().hasChildren()))
            return false;

        leafFound = (node.hasLeft() && node.getLeft().isLeaf()) || (node.hasRight() && node.getRight().isLeaf());
        return isBalanced1(node.getLeft(), leafFound) && isBalanced1(node.getRight(), leafFound);
    }

    private TreeNode getUnBalancedTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        node4.setRight(node7);
        node5.setRight(node8);

        return node1;
    }

    private TreeNode getAnotherUnBalancedTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node6.setLeft(node7);
        node7.setRight(node8);

        return node1;
    }

    private TreeNode getPerfectTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        return node1;
    }

    private TreeNode getBalancedTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        return node1;
    }
}
