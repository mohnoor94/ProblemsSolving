package object_oriented_design;

import java.util.ArrayList;

/**
 * Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 7.12)
 */
@SuppressWarnings("WeakerAccess")
public class HashTable<K, V> {

    private ArrayList<PairNode> entries;

    public HashTable(int capacity) {
        entries = new ArrayList<>();
        entries.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) entries.add(null);
    }

    @SuppressWarnings("UnusedReturnValue")
    public V put(K key, V value) {
        if (key == null) throw new RuntimeException("Null Key");
        PairNode node = getNodeForKey(key);
        if (node != null) {
            V v = node.value;
            node.value = value;
            return v; // return old value
        }

        node = new PairNode(key, value);
        int h = hash(key);
        if (entries.get(h) != null) {
            node.next = entries.get(h);
            node.next.prev = node;
        }
        entries.set(h, node);
        return null;
    }

    public V get(K key) {
        if (key == null) return null;
        PairNode node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public V remove(K key) {
        if (key == null) return null;
        PairNode node = getNodeForKey(key);
        if (node == null) return null;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else { // removing head
            entries.set(hash(key), node.next);
        }

        if (node.next != null){
            node.next.prev = node.prev;
        }

        return node.value;
    }

    private PairNode getNodeForKey(K key) {
        int h = hash(key);
        PairNode node = entries.get(h);

        while (node != null) {
            if (node.key == key) return node;
            node = node.next;
        }

        return null;
    }

    private int hash(K key) {
        return key.hashCode() % entries.size();
    }

    private class PairNode {
        K key;
        V value;
        PairNode next;
        PairNode prev;

        PairNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

class HashTableTest {

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>(1024);

        System.out.println(table.get(1));

        table.put(1, "One");
        System.out.println(table.get(1));

        table.remove(1);
        System.out.println(table.get(1));

        table.put(2, "Two");

        table.put(3, "Three");
        System.out.println(table.get(3));

        table.put(3, "Three2");
        System.out.println(table.get(3));
    }
}

