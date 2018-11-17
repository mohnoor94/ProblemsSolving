package util;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int headData) {
        head = new Node(headData);
    }

    public Node append(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return node;
        }

        Node p = head;
        while (p.next != null) p = p.next;
        p.next = node;
        return node;
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