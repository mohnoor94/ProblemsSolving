package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphNode {
    private char data;
    private List<GraphNode> children = new ArrayList<>();
    private boolean visited;

    public GraphNode(char data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    public void setChildren(GraphNode... children) {
        this.children.addAll(Arrays.asList(children));
    }

    public void addChild(GraphNode child) {
        children.add(child);
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean notVisited() {
        return !visited;
    }

    public void visit() {
        setVisited(true);
    }

    public void unVisit() {
        setVisited(false);
    }

    private void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}