package trie;

public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(String key) {
        Node tmp = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = (c - 'a');

            if (tmp.hasChild(index)) {
                tmp = tmp.getChild(index);
            } else {
                Node node = new Node(c);
                tmp.setChild(index, node);
                tmp = node;
            }
        }

        tmp.setLeaf(true);
    }

    // Time: O(length(key))
    public boolean search(String key) {
        Node tmp = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = (c - 'a');

            if (!tmp.hasChild(index)) return false;

            tmp = tmp.getChild(index);
        }

        // return tmp.isLeaf();
        return true; // allow substring search
    }
}
