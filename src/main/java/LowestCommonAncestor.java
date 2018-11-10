import java.util.ArrayList;
import java.util.List;

/**
 * *** 'Microsoft' interview question ***
 *
 * Find the lowest common ancestor of two items in a binary tree.
 *
 * Problem statement: https://youtu.be/GnliEfQo114
 */
public class LowestCommonAncestor {

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
        TreeNode tree = new TreeNode(0, new TreeNode(1, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(2, new TreeNode(5, null, null), new TreeNode(6, null, null)));
        System.out.println(findLowestCommonAncestor(tree, 3, 4));
        System.out.println(findLowestCommonAncestor(tree, 3, 5));
        System.out.println(findLowestCommonAncestor(tree, 3, 3));
        System.out.println(findLowestCommonAncestor(tree, 1, 6));
        System.out.println(findLowestCommonAncestor(tree, 0, 6));
        System.out.println(findLowestCommonAncestor(tree, 0, 9));
        System.out.println(findLowestCommonAncestor(null, 0, 2));
    }

    private static Integer findLowestCommonAncestor(TreeNode root, int child1, int child2) {
        if (root == null) return null;

        List<Integer> path1 = findPathToChild(root, child1);
        List<Integer> path2 = findPathToChild(root, child2);

        if (path1 == null || path2 == null) return null;
        if (child1 == child2) return child1;

        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) i++;

        return path1.get(i - 1);
    }

    private static List<Integer> findPathToChild(TreeNode node, int goal) {
        if (node == null) return null;
        if (node.value == goal) return List.of(node.value);

        List<Integer> leftPath = findPathToChild(node.left, goal);
        if (leftPath != null) return addNodeToPath(node, leftPath);

        List<Integer> rightPath = findPathToChild(node.right, goal);
        if (rightPath != null) return addNodeToPath(node, rightPath);

        return null;
    }

    // the path could be better represented by a stack!
    private static List<Integer> addNodeToPath(TreeNode node, List<Integer> path) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node.value);
        result.addAll(path);
        return result;
    }
}