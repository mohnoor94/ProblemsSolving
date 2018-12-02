package datastructure;

public class GenericQueue<T> {
    private GenericNode<T> first;
    private GenericNode<T> last;

    public void add(T item) {
        GenericNode<T> node = new GenericNode<>(item);

        if (first == null) first = node;
        if (last != null) last.setNext(node);

        last = node;
    }

    public T remove() {
        if (isEmpty()) return null;

        T node = first.getData();
        first = first.getNext();

        return node;
    }

    public T peek(){
        if (isEmpty()) return null;

        return first.getData();
    }

    public boolean isEmpty(){
        return first == null;
    }
}
