import jdk.jshell.spi.ExecutionControl;
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

    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        CheckBalancedTree solution = new CheckBalancedTree();

        TreeNode balancedTree = solution.getBalancedTree();
        TreeNode perfectTree = solution.getPerfectTree();
        TreeNode unBalancedTree = solution.getUnBalancedTree();

        System.out.println(solution.isBalanced(perfectTree));
        System.out.println(solution.isBalanced(balancedTree));
        System.out.println(solution.isBalanced(unBalancedTree));
    }

    private boolean isBalanced(TreeNode node) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Solution not yet implemented...");
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
