package trie;

import java.util.Arrays;

public class Node {

    private char character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;

    public Node(char character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];
    }

    public void setChild(int index, Node value) {
        children[index] = value;
    }

    public Node getChild(int index) {
        return children[index];
    }

    public boolean hasChild(int index) {
        return children[index] != null;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character='" + character + '\'' +
                ", children=" + Arrays.toString(children) +
                ", leaf=" + leaf +
                ", visited=" + visited +
                '}';
    }
}
