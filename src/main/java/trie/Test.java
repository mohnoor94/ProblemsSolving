package trie;

public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();

        System.out.println(trie.search("noor"));
        System.out.println(trie.search("noora"));
        System.out.println(trie.search("noore"));
        trie.insert("noor");
        trie.insert("noora");
        System.out.println(trie.search("noor"));
        System.out.println(trie.search("noora"));
        System.out.println(trie.search("noore"));
    }
}
