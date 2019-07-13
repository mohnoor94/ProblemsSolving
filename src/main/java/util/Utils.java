package util;

import node.implementation.Node;

public class Utils {

    public static Node insertBefore(Node node, int newNodeData) {
        Node newNode = new Node(newNodeData);
        if (node != null) newNode.next = node;
        return newNode;
    }

    public static int getLength(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static Node padWith(Node node, int value, int number) {
        for (int i = 0; i < number; i++) {
            node = Utils.insertBefore(node, value);
        }
        return node;
    }
}
