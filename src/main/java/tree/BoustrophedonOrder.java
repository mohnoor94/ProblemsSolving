package tree;

import tree.implementation.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * *** 'Morgan Stanley' interview question ***
 * ***
 * In Ancient Greece, it was common to write text with the first line going left to right, the second line going right
 * to left, and continuing to go back and forth. This style was called "boustrophedon".
 * ***
 * Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
 * ***
 * This is also called ZigZag.
 * ***
 */
public class BoustrophedonOrder {

    private void printLevels(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node != null) {
                System.out.print(node);
                if (node.hasLeft()) q.add(node.getLeft());
                if (node.hasRight()) q.add(node.getRight());
            } else {
                System.out.println();
                if (!q.isEmpty()) q.add(null);
            }
        }
    }

    private void printBoustrophedon(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> currentLevel = new LinkedList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.push(root);
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            System.out.print(node);

            if (leftToRight) {
                if (node.hasLeft()) nextLevel.push(node.getLeft());
                if (node.hasRight()) nextLevel.push(node.getRight());
            } else {
                if (node.hasRight()) nextLevel.push(node.getRight());
                if (node.hasLeft()) nextLevel.push(node.getLeft());
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BoustrophedonOrder solution = new BoustrophedonOrder();

        TreeNode left = new TreeNode(2, 4, 5);
        TreeNode right = new TreeNode(3, 6, 7);
        TreeNode tree = new TreeNode(1, left, right);

        solution.printLevels(tree);
        System.out.println("====================");
        solution.printBoustrophedon(tree);
    }
}
