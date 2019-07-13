package graph.implementation;

import java.util.Arrays;
import java.util.List;

public class Graph {
    private List<GraphNode> nodes;

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(GraphNode... nodes) {
        setNodes(Arrays.asList(nodes));
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void reset() {
        nodes.forEach(GraphNode::unVisit);
    }
}
