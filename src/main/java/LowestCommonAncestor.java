import java.util.ArrayList;
import java.util.List;

/**
 * *** 'Microsoft' interview question ***
 * <p>
 * Problem statement: https://youtu.be/GnliEfQo114
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node tree = new Node(50);
        tree.insert(10);
        tree.insert(20);
        tree.insert(200);
        tree.insert(100);
        tree.insert(1);
        tree.insert(1000);

        tree.printInOrder();

        System.out.println(tree.findLowestCommonAncestor(50, 200));
        System.out.println(tree.findLowestCommonAncestor(10, 200));
        System.out.println(tree.findLowestCommonAncestor(10, 10));
        System.out.println(tree.findLowestCommonAncestor(20, 1));
        System.out.println(tree.findLowestCommonAncestor(1000, 100));
        System.out.println(tree.findLowestCommonAncestor(1000, 200));
        System.out.println(tree.findLowestCommonAncestor(1000, 105));
        System.out.println(tree.findLowestCommonAncestor(105, 105));
        System.out.println(tree.findLowestCommonAncestor(500, 105));
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        void insert(int value) {
            if (value < data) {
                if (hasLeft())
                    left.insert(value);
                else
                    left = new Node(value);
            } else {
                if (hasRight())
                    right.insert(value);
                else
                    right = new Node(value);
            }
        }

        Integer findLowestCommonAncestor(int value1, int value2) {
            List<Integer> path1 = getPath(value1);
            List<Integer> path2 = getPath(value2);

            if (path1 == null || path2 == null) return null;
            if (value1 == value2) return value1;

            Integer common = null;
            for (int i = 0; i < path1.size() && i < path2.size(); i++)
                if (path1.get(i).equals(path2.get(i))) common = path1.get(i);

            return common;
        }

        List<Integer> getPath(int goal) {
            return getPath(goal, new ArrayList<>());
        }

        private List<Integer> getPath(int goal, ArrayList<Integer> path) {
            path.add(data);
            if (data == goal) return path;
            if (goal < data && hasLeft()) return left.getPath(goal, path);
            if (hasRight()) return right.getPath(goal, path);
            return null; // no path!
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        void printInOrder() {
            ArrayList<Integer> list = new ArrayList<>();
            traverseInOrder(list);
            System.out.println(list);
        }

        void traverseInOrder(ArrayList<Integer> list) {
            if (hasLeft()) left.traverseInOrder(list);
            list.add(data);
            if (hasRight()) right.traverseInOrder(list);
        }
    }
}