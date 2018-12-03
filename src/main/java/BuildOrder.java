import graph.Graph;
import graph.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects where the second
 * project is dependent on the first project).
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error.
 * ***
 * Example:
 * * Input:
 * -- projects:     a, b, c, d, e, f
 * -- dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * * Output: f, e, a, b, d, c
 * ***
 * Example:
 * * Input:
 * -- projects:     a, b, c, d, e, f
 * -- dependencies: (a, d), (f, b), (b, d), (f, a), (d, c), (c, a)
 * * Output: ERROR (or null)
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 4.7)
 * ***
 * TODO: Revisit this problem!!!
 */
@SuppressWarnings("Duplicates")
public class BuildOrder {

    public static void main(String[] args) {
        runFirstExample();
        runSecondExample();
    }

    private static List<GraphNode> buildRoute(Graph graph) {
        List<GraphNode> nodes = graph.getNodes();
        List<GraphNode> route = new ArrayList<>();

        for (GraphNode node : nodes) {
            visitAndAdd(node, route, !node.hasChildren());
        }

        for (GraphNode node : nodes)
            if (node.notVisited() && !canComplete(node, new HashSet<>(), route)) return null;

        return route;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean canComplete(GraphNode node, Set<GraphNode> parents, List<GraphNode> route) {
        if (node == null || !node.hasChildren()) return true;

        if (parents.contains(node)) return false;

        parents.add(node);

        for (GraphNode child : node.getChildren()) {
            if (!canComplete(child, new HashSet<>(parents), route)) return false;
            visitAndAdd(child, route, child.notVisited());
        }
        visitAndAdd(node, route, node.notVisited());

        return true;
    }

    private static void visitAndAdd(GraphNode node, List<GraphNode> route, boolean condition) {
        if (condition) {
            route.add(node);
            node.visit();
        }
    }

    private static void runFirstExample() {
        Graph graph = new Graph();

        GraphNode a = new GraphNode('a');
        GraphNode b = new GraphNode('b');
        GraphNode c = new GraphNode('c');
        GraphNode d = new GraphNode('d');
        GraphNode e = new GraphNode('e');
        GraphNode f = new GraphNode('f');

        graph.setNodes(a, b, c, d, e, f);

        d.addChild(a);
        b.addChild(f);
        d.addChild(b);
        a.addChild(f);
        c.addChild(d);

        System.out.println(buildRoute(graph));

        graph.reset();
        a.addChild(c);
        System.out.println(buildRoute(graph));
    }


    private static void runSecondExample() {
        Graph graph = new Graph();

        GraphNode a = new GraphNode('a');
        GraphNode b = new GraphNode('b');
        GraphNode c = new GraphNode('c');
        GraphNode d = new GraphNode('d');
        GraphNode e = new GraphNode('e');
        GraphNode f = new GraphNode('f');
        GraphNode g = new GraphNode('g');

        graph.setNodes(a, b, c, d, e, f, g);

        g.addChild(d);
        e.addChild(a);
        e.addChild(b);
        a.addChild(c);
        a.addChild(b);
        a.addChild(f);
        b.addChild(f);
        c.addChild(f);

        System.out.println(buildRoute(graph));
    }
}
