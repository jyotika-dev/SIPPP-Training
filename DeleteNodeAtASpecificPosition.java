// https://www.geeksforgeeks.org/dsa/delete-a-linked-list-node-at-a-given-position/
// Java program to delete a linked list node at a given
// position

class Node {

    int data;
    Node next;

    Node(int d) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodeAtASpecificPosition {

    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 1) {
            Node newHead = head.next;
            return newHead;
        }
        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < position) {
            previous = current;
            current = current.next;
            count++;
        }
        if (current != null) {
            previous.next = current.next;
        }
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        Node current = head;

        while (current != null) {
            System.out.println(current.data + (current.next == null ? "" : "->"));
            current = current.next;
        }
        System.out.println();
    }
}
