package graph;

public class GraphNode {
    private int data;
    private GraphNode[] children;

    public GraphNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public GraphNode[] getChildren() {
        return children;
    }

    public void setChildren(GraphNode... children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "data=" + data +
                '}';
    }
}