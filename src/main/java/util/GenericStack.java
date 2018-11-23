package util;

public class GenericStack<T> {
    private GenericNode<T> top;

    public T peek() {
        if (isEmpty()) return null;
        return top.getData();
    }

    public T pop() {
        if (isEmpty()) return null;

        T data = top.getData();
        top = top.getNext();

        return data;
    }

    public void push(T item) {
        GenericNode<T> newNode = new GenericNode<>(item);
        newNode.setNext(top);
        top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
