import util.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
 * E,g,. if you have a tree with depth D, you'll have D linked lists.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.3)
 */
public class ListOfDepths {

    public static void main(String[] args) {
        // solution 1:
        TreeNode node = getTreeNode();
        ArrayList<LinkedList<TreeNode>> depths1 = getDepths1(node);
        printSolution(depths1);

        System.out.println("\n");

        // solution 2:
        ArrayList<LinkedList<TreeNode>> depths2 = getDepths2(node);
        printSolution(depths2);

        System.out.println("\n");

        // solution 3:
        ArrayList<LinkedList<TreeNode>> depths3 = getDepths3(node);
        printSolution(depths3);
    }

    /**
     * Time:    O(n);   n: number of nodes
     * Space:   O(n)
     */
    private static ArrayList<LinkedList<TreeNode>> getDepths3(TreeNode node) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (node != null) current.add(node);

        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.hasLeft()) current.add(parent.getLeft());
                if (parent.hasRight()) current.add(parent.getRight());
            }
        }

        return result;
    }

    /**
     * Time:    O(n);   n: number of nodes
     * Space:   O(n)
     */
    private static ArrayList<LinkedList<TreeNode>> getDepths2(TreeNode node) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(node, lists, 0);
        return lists;
    }

    private static void createLevelLinkedList(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (node == null) return;

        LinkedList<TreeNode> list;
        if (level == lists.size()) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(node);
        createLevelLinkedList(node.getLeft(), lists, level + 1);
        createLevelLinkedList(node.getRight(), lists, level + 1);
    }

    /**
     * Time:    O(n);   n: number of nodes
     * Space:   O(n)
     */
    private static ArrayList<LinkedList<TreeNode>> getDepths1(TreeNode node) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.add(null);

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode treeNode = nodes.get(i);
            if (treeNode == null && i == nodes.size() - 1) {
                nodes.remove(i);
                break;
            } else if (treeNode == null) nodes.add(null);
            else {
                if (treeNode.hasLeft()) nodes.add(treeNode.getLeft());
                if (treeNode.hasRight()) nodes.add(treeNode.getRight());
            }
        }

        ArrayList<LinkedList<TreeNode>> depths = new ArrayList<>();
        depths.add(new LinkedList<>());

        for (TreeNode treeNode : nodes) {
            if (treeNode == null) depths.add(new LinkedList<>());
            else depths.get(depths.size() - 1).add(treeNode);
        }

        return depths;
    }

    private static TreeNode getTreeNode() {
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
        node3.setRight(node6);
        node5.setLeft(node7);
        node6.setRight(node8);

        return node1;
    }

    private static void printSolution(ArrayList<LinkedList<TreeNode>> depths) {
        depths.forEach(list -> {
            list.forEach(node -> System.out.print(node + ", "));
            System.out.println();
        });
    }
}
