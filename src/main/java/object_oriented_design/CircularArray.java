package object_oriented_design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement a CircularArray class that supports an array-like data structure which can efficiency rotated.
 * If possible, the class should use a generic type, and should support iteration via the standard
 * for (Obj o: circularArray) notation.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 7.9)
 */
@SuppressWarnings("WeakerAccess")
public class CircularArray<T> implements Iterable<T> {
    private List<T> list = new ArrayList<>();
    private int head;

    public CircularArray() {
    }

    private int convert(int index) {
        if (index < 0) {
            index += list.size();
        }

        return (head + index) % list.size();
    }

    public void rotate(int rightShift) {
        head = convert(rightShift);
    }

    public void set(int index, T value) {
        list.set(convert(index), value);
    }

    public void add(T value) {
        list.add(value);
    }

    public T get(int index) {
        return list.get(convert(index));
    }

    public T remove(int index) {
        return list.remove(convert(index));
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int current = -1;
        private T lastRead;

        @Override
        public boolean hasNext() {
            return current < list.size() - 1;
        }

        @Override
        public T next() {
            current++;
            lastRead = list.get(convert(current));
            return lastRead;
        }

        @Override
        public void remove() {
            current--;
            list.remove(lastRead);
        }
    }
}

class TestCircularArray {

    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArray<>();

        circularArray.add(1);
        circularArray.add(2);
        circularArray.add(3);
        circularArray.add(4);

        printArray(circularArray);

        circularArray.set(2, 5);

        printArray(circularArray);

        circularArray.set(2, 3);
        circularArray.rotate(2);

        printArray(circularArray);

        circularArray.rotate(2);

        printArray(circularArray);

        circularArray.remove(2);

        printArray(circularArray);

        circularArray.remove(5);

        printArray(circularArray);

        System.out.println("###############################################################");

        CircularArray<Integer> second = new CircularArray<>();

        second.add(5);
        second.add(10);
        second.add(15);
        second.add(20);
        second.add(25);

        for (Integer integer : second) {
            System.out.println(integer);
        }
        System.out.println("///////////////////");

        second.forEach(System.out::println);
        System.out.println("///////////////////");

        second.iterator().forEachRemaining(System.out::println);
    }

    private static void printArray(CircularArray<Integer> circularArray) {
        for (int i = 0; i < circularArray.size(); i++) {
            System.out.println(circularArray.get(i));
        }
        System.out.println("*****************");
    }
}