import java.util.*;

/**
 * Go over a graph (directed or undirected) and log the node values.
 * - The graph could have unconnected components (nodes).
 * <p>
 * - More details: https://youtu.be/RqrKs5dV1kE
 */
public class GraphDepthFirstSearchTraversal {

    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');

        Graph graph = new Graph();
        graph.vertices = List.of(a, b, c, d, e, f, g);
        graph.edges = Map.of(a, List.of(b),
                b, List.of(a, c, d),
                c, List.of(b, d),
                d, List.of(b, c),
                e, List.of(f),
                f, List.of(e),
                g, Collections.emptyList());

        dfsTraverse(graph);
    }

    private static void dfsTraverse(Graph graph) {
        Set<Node> visited = new HashSet<>();
        graph.vertices.forEach(v -> {
            if (!visited.contains(v)) visit(v, visited, graph.edges);
        });
    }

    private static void visit(Node vertex, Set<Node> visited, Map<Node, List<Node>> edges) {
        visited.add(vertex);
        System.out.println(vertex.value);

        edges.get(vertex).forEach(adjacent -> {
            if (!visited.contains(adjacent)) visit(adjacent, visited, edges);
        });
    }

    static class Graph {
        List<Node> vertices;
        Map<Node, List<Node>> edges;
    }

    static class Node {
        char value;

        Node(char value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}