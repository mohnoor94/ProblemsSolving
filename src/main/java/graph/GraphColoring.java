package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * Given an undirected graph with maximum degree D, find a graph coloring using at most D+1 colors.
 * ***
 * https://www.interviewcake.com/question/graph-coloring?course=fc1&section=trees-graphs
 */
public class GraphColoring {

    /**
     * Time: O( N * D ) ==> O (M + N) [linear!] since each edge will add 2 neighbors
     * Space: O( D )
     * where:
     * N: Nodes
     * M: Edges
     * D: Degree - max number of neighbors
     */
    public static void colorGraph(GraphNode[] graph, String[] colors) {
        for (GraphNode node : graph) {
            if (node.hasColor()) break;

            Set<String> illegalColors = new HashSet<>();

            // When we get the illegal colors for each node, we iterate through that node's neighbors.
            // So in total, we cross each of the graphs MM edges twice: once for the node on either end of each edge.
            // O(M) time.
            for (GraphNode neighbor : node.getNeighbors()) {
                if (node.equals(neighbor)) throw new RuntimeException("Loop!");
                if (neighbor.hasColor()) illegalColors.add(neighbor.getColor());
            }

            // When we assign a color to each node, we're careful to stop checking colors as soon as we find one that
            // works. In the worst case, we'll have to check one more color than the total number of neighbors.
            // Again, each edge in the graph adds two neighbors—one for the node on either end—so there are 2∗M
            // neighbors. So, in total, we'll have to try O(N+M) colors.
            for (String color : colors) {
                if (!illegalColors.contains(color)) {
                    node.setColor(color);
                    break;
                }
            }
        }
    }

    public static class GraphNode {
        private final String label;
        private final Set<GraphNode> neighbors;
        private Optional<String> color;

        public GraphNode(String label) {
            this.label = label;
            neighbors = new HashSet<>();
            color = Optional.empty();
        }

        public String getLabel() {
            return label;
        }

        public Set<GraphNode> getNeighbors() {
            return Collections.unmodifiableSet(neighbors);
        }

        public void addNeighbor(GraphNode neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasColor() {
            return color.isPresent();
        }

        public String getColor() {
            return color.get();
        }

        public void setColor(String color) {
            this.color = Optional.ofNullable(color);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GraphNode graphNode = (GraphNode) o;

            return label.equals(graphNode.label);
        }

        @Override
        public int hashCode() {
            return label.hashCode();
        }
    }


    // tests
    @Test
    public void lineGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeC.addNeighbor(nodeB);
        nodeC.addNeighbor(nodeD);
        nodeD.addNeighbor(nodeC);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void separateGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeD);
        nodeD.addNeighbor(nodeC);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void triangleGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeC.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeB);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void envelopeGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        final GraphNode nodeE = new GraphNode("E");
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeB);
        nodeC.addNeighbor(nodeD);
        nodeC.addNeighbor(nodeE);
        nodeD.addNeighbor(nodeB);
        nodeD.addNeighbor(nodeC);
        nodeD.addNeighbor(nodeE);
        nodeE.addNeighbor(nodeB);
        nodeE.addNeighbor(nodeC);
        nodeE.addNeighbor(nodeD);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD, nodeE};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test(expected = Exception.class)
    public void loopGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        nodeA.addNeighbor(nodeA);
        final GraphNode[] graph = new GraphNode[]{nodeA};
        colorGraph(graph, getColors());
    }

    private static String[] getColors() {
        return new String[]{"red", "green", "blue", "orange", "yellow", "white"};
    }

    private static void validateGraphColoring(GraphNode[] graph) {

        for (final GraphNode node : graph) {
            if (!node.hasColor()) {
                fail(String.format("Found non-colored node %s", node.getLabel()));
            }
        }

        int maxDegree = 0;
        final Set<String> usedColors = new HashSet<>();

        for (final GraphNode node : graph) {
            final Set<GraphNode> neighbors = node.getNeighbors();
            maxDegree = Math.max(maxDegree, neighbors.size());
            usedColors.add(node.getColor());
        }

        final int allowedColorCount = maxDegree + 1;

        if (usedColors.size() > allowedColorCount) {
            fail(String.format("Too many colors: %d allowed, but %d actually used",
                    allowedColorCount, usedColors.size()));
        }

        for (final GraphNode node : graph) {
            final Set<GraphNode> neighbors = node.getNeighbors();
            for (final GraphNode neighbor : neighbors) {
                if (neighbor.getColor().equals(node.getColor())) {
                    fail(String.format("Neighbor nodes %s and %s have the same color %s",
                            node.getLabel(), neighbor.getLabel(), node.getColor()));
                }
            }
        }
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(GraphColoring.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}