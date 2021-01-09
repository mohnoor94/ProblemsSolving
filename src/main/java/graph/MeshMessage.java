package graph;


import java.util.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.
 * <p>
 * Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each
 * message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are
 * encrypted while they're in transit.)
 * <p>
 * Some friends have been using your service, and they're complaining that it takes a long time for messages to get
 * delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from
 * the sender to the recipient.
 * <p>
 * Given information about active users on the network, find the shortest route for a message from one user (the sender)
 * to another (the recipient). Return an array of users that make up this route.
 * <p>
 * *** There might be a few shortest delivery routes, all with the same length. For now, let's just return any shortest
 * route. ***
 * <p>
 * ----
 * Your network information takes the form of a hash map mapping username strings to an array of other users nearby.
 * <p>
 * * Example:
 * Map<String, String[]> network = new HashMap<String, String[]>() {{
 * put("Min",     new String[] { "William", "Jayden", "Omar" });
 * put("William", new String[] { "Min", "Noam" });
 * put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
 * put("Ren",     new String[] { "Jayden", "Omar" });
 * put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
 * put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
 * put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
 * put("Noam",    new String[] { "Nathan", "Jayden", "William" });
 * put("Omar",    new String[] { "Ren", "Min", "Scott" });
 * ...
 * }};
 * <p>
 * - For the network above, a message from Jayden to Adam should have this route:
 * { "Jayden", "Amelia", "Adam" }
 * <p>
 * ***
 * <p>
 * Additional (Generic) Notes:
 * - BFS and DFS are common enough that it's often acceptable to just state their complexity as O(N+M)O(N+M).
 * Some interviewers might want you to derive it though, so definitely be ready in case they ask.
 * - Our app's design has a formal name: a mesh network. In a mesh network, data is sent from one node (here, a phone)
 * to another directly, rather than through intermediate devices (here, cell towers). Assuming enough devices are in
 * range, mesh networks provide multiple possible transmission paths, making them reliable even if some devices have
 * failed.
 * <p>
 * ***
 * https://www.interviewcake.com/question/java/mesh-message
 */
public class MeshMessage {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {
        return bfsGetPath(graph, startNode, endNode);
    }

    /**
     * Time Complexity: O(N+M)
     * Space Complexity: O(N)
     * <p>
     * N: Nodes
     * M: Neighbors
     */
    public static String[] bfsGetPath(Map<String, String[]> graph, String startNode, String endNode) {
        if (!graph.containsKey(startNode)) {
            throw new IllegalArgumentException("Start node not in graph");
        }
        if (!graph.containsKey(endNode)) {
            throw new IllegalArgumentException("End node not in graph");
        }

        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        Map<String, String> howWeReachedNodes = new HashMap<>();
        howWeReachedNodes.put(startNode, null);

        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.remove();
            if (currentNode.equals(endNode)) {
                return reconstructPath(endNode, howWeReachedNodes);
            }

            for (String neighbor : graph.get(currentNode)) {
                if (!howWeReachedNodes.containsKey(neighbor)) {
                    nodesToVisit.add(neighbor);
                    howWeReachedNodes.put(neighbor, currentNode);
                }
            }
        }

        return null;
    }

    private static String[] reconstructPath(String endNode, Map<String, String> howWeReachedNodes) {
        ArrayList<String> reversedPath = new ArrayList<>();
        reversedPath.add(endNode);

        String parent = howWeReachedNodes.get(endNode);
        while (parent != null) {
            reversedPath.add(parent);
            parent = howWeReachedNodes.get(parent);
        }

        int length = reversedPath.size();
        String[] path = new String[length];
        for (int i = 0; i < length; i++) {
            path[length - 1 - i] = reversedPath.get(i);
        }

        return path;
    }

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
    }

    private static Map<String, String[]> getNetwork() {
        return new HashMap<>() {
            {
                put("a", new String[]{"b", "c", "d"});
                put("b", new String[]{"a", "d"});
                put("c", new String[]{"a", "e"});
                put("d", new String[]{"a", "b"});
                put("e", new String[]{"c"});
                put("f", new String[]{"g"});
                put("g", new String[]{"f"});
            }
        };
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MeshMessage.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}