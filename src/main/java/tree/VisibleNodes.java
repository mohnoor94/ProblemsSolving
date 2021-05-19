package tree;

/**
 * *** 'Microsoft' OTS (Online Technical Screen) question ***
 * ***
 * A binary tree T is given. A node of tree T contacting value V is described as visible if the path from the root of
 * the tree to the node does not a node with any value exceeding V.
 * In particular, the root is always visible, and nodes with values lower than that of the root are never visible.
 * > Given a binary tree T consisting of N nodes, return its number of visible nodes.
 * ---
 * Example:
 *                      8
 *                 /        \
 *                2         9
 *            /     \
 *           8      7
 *
 * > Visible Nodes: 3 (8, 8, 9)
 */
public class VisibleNodes {

    private static class Tree {
        private final int value;
        private Tree left;
        private Tree right;

        Tree(int value) { this.value = value; }
    }

    private int countVisibleNodes(Tree tree) {
        return countVisibleNodes(tree, Integer.MIN_VALUE);
    }

    /**
     * Time: O(n)
     * Space: O(n) in Java - O(1) in languages with recursion-tail optimization like Scala.
     */
    private int countVisibleNodes(Tree tree, int minValue) {
        if (tree == null) return 0;

        final int result = tree.value >= minValue ? 1 : 0;
        final int newMinValue = Math.max(minValue, tree.value);
        System.out.println("[DEBUG]: result = " + result + ", value = " + tree.value);

        return result
                + countVisibleNodes(tree.left, newMinValue)
                + countVisibleNodes(tree.right, newMinValue);
    }


    public static void main(String[] args) {
        // Light test
        final Tree tree = new Tree(8);
        final Tree left = new Tree(2);
        left.left = new Tree(8);
        left.right = new Tree(7);
        tree.left = left;
        tree.right = new Tree(9);

        final VisibleNodes visibleNodes = new VisibleNodes();
        System.out.println(visibleNodes.countVisibleNodes(tree));
    }
}
