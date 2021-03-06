package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., Code Library)
 */
public class HashMapList<T, E> {
    private HashMap<T, ArrayList<E>> map = new HashMap<>();

    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(item);
    }

    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    public boolean containsKeyValue(T key, E item) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(item);
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    public Collection<ArrayList<E>> values() {
        return map.values();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
