package util.tree;

public class TreeNode {

    private int data;
    private TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void print() {
        inorderPrint();
        System.out.println();
    }

    private void inorderPrint() {
        if (left != null) left.inorderPrint();
        System.out.print(data + ", ");
        if (right != null) right.inorderPrint();
    }

    @Override
    public String toString() {
        return "TreeNode{" + data + '}';
    }
}
