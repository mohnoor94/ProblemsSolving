package datastructure;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
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
        return String.valueOf(data);
    }
}