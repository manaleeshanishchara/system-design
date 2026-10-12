package DSA.DoublyLinkedList;

public class DoublyLinkedList {

    private static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    // add methods
    // addFirst, addLast, addIndex

    public void addFirst(int val) {
        Node curr = new Node(val);
        if (head == null) {
            head = tail = curr;
        } else {
            curr.next = head;
            curr.prev = null;
            head.prev = curr;
            head = curr;
        }
        size++;
    }

    public void addLast(int val) {
        Node curr = new Node(val);
        if (head == null) {
            head = tail = curr;
        } else {
            curr.prev = tail;
            curr.next = null;
            tail.next = curr;
            tail = curr;
        }
        size++;
    }

    public void addIndex(int index, int val) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }

        Node node = new Node(val);
        Node curr = getNode(index);

        node.next = curr;
        node.prev = curr.prev;
        curr.prev.next = node;
        curr.prev = node;
        size++;

    }

    public void printForward() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? "<-->" : "\n"));
            curr = curr.next;
        }
    }

    // 1->2->3
    private Node getNode(int index) {

        Node curr;

        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(23);
        list.addFirst(15);
        list.addFirst(85);
        list.addIndex(2, 99);

        list.printForward();

        System.out.println("Hello World");
    }
}
