package util;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int headData) {
        head = new Node(headData);
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node p = head;
        while (p.next != null) p = p.next;
        p.next = new Node(data);
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println();
    }
}