package datastructure.node.implementation;

public class GenericNode<T> {
    private T data;
    private GenericNode<T> next;

    public GenericNode(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void print() {
        recursivePrint();
        System.out.println();
    }

    private void recursivePrint() {
        System.out.print(data);
        if (next != null) {
            System.out.print(" -> ");
            next.recursivePrint();
        }
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
