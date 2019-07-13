package tree.implementation;

public class TreeNodeWithParent extends TreeNode {
    private TreeNodeWithParent parent;

    public TreeNodeWithParent(int data) {
        super(data);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public TreeNodeWithParent getParent() {
        return parent;
    }

    @Override
    public void setLeft(TreeNode left) {
        super.setLeft(left);
        left.asTreeNodeWithParent().parent = this;
    }

    @Override
    public void setRight(TreeNode right) {
        super.setRight(right);
        right.asTreeNodeWithParent().parent = this;
    }

    @Override
    public String toString() {
        return "TreeNodeWithParent{" + getData() + '}';
    }
}
