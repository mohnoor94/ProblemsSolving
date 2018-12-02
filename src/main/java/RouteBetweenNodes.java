import graph.GraphNode;

import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.1)
 */
public class RouteBetweenNodes {

    public static void main(String[] args) {
        testSolution();
    }

    /**
     * TODO: Review this comment!
     * Basic BFS or DFS algorithm could easily solve this problem.
     * I solved it using bidirectional search, so that each node check if any of each children is visited by the other
     * node and thus they will have a route between.
     * ***
     * Assume that:
     * - n is the number of nodes.
     * - Each node has at most k children.
     * - Shortest path between two nodes has the length d.
     * Then:
     * Time:    O(k^(d/2)); BFS will take k^d; which is k^(d/2) slower.
     * Space:   O(n); BFS will need X/2 space.
     * In the case of no path BFS and our approach may take similar time.
     */
    private static boolean canFindRoute(GraphNode node1, GraphNode node2) {
        if (node1 == node2 || node1.getData() == node2.getData()) return true;

        Set<Integer> n1Visited = new HashSet<>();
        Set<Integer> n2Visited = new HashSet<>();
        LinkedList<GraphNode> q1 = new LinkedList<>();
        LinkedList<GraphNode> q2 = new LinkedList<>();

        q1.add(node1);
        q2.add(node2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (hasIntersection(n1Visited, n2Visited, q1)) return true;
            if (hasIntersection(n2Visited, n1Visited, q2)) return true;
        }

        return false;
    }

    private static boolean hasIntersection(Set<Integer> myVisitedNode, Set<Integer> theirVisitedNode, LinkedList<GraphNode> nodeQueue) {
        if (!nodeQueue.isEmpty()) {
            GraphNode node = nodeQueue.removeFirst();
            if (theirVisitedNode.contains(node.getData())) return true;
            myVisitedNode.add(node.getData());
            for (GraphNode child : node.getChildren()) {
                if (!myVisitedNode.contains(child.getData()))
                    nodeQueue.add(child);
            }
        }
        return false;
    }

    private static void testSolution() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);

        node1.setChildren(node2);
        node2.setChildren(node3);
        node3.setChildren(node2);
        node4.setChildren(node5, node7);
        node5.setChildren(node6);
        node6.setChildren(node7, node4);
        node7.setChildren(node5);

        System.out.println(canFindRoute(node1, node3));
        System.out.println(canFindRoute(node1, node7));
        System.out.println(canFindRoute(node7, node7));
        System.out.println(canFindRoute(node6, node7));
        System.out.println(canFindRoute(node4, node7));
        System.out.println(canFindRoute(node4, node6));
        System.out.println(canFindRoute(node6, node4));
        System.out.println(canFindRoute(node2, node3));
        System.out.println(canFindRoute(node2, node5));
    }
}
