package DSA.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        System.out.println("After inserting 10, 20, 30 at tail: " + list);

        list.insertAtHead(5);
        System.out.println("After inserting 5 at head: " + list);

        list.insertAtIndex(2, 15);
        System.out.println("After inserting 15 at index 2: " + list);

        System.out.println("Size: " + list.size());
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Contains 99: " + list.contains(99));

        list.delete(15);
        System.out.println("After deleting value 15: " + list);

        list.deleteAtIndex(0);
        System.out.println("After deleting index 0: " + list);

        list.reverse();
        System.out.println("After reversing: " + list);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

/*
 * Custom singly linked list backed by Node objects (no java.util.LinkedList).
 * Insert/delete at head: O(1)
 * Insert/delete at tail or index: O(n)
 * Search (contains): O(n)
 * Space: O(n)
 */
class LinkedList {
    private Node head;
    private int size;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void insertAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    public boolean delete(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        Node previous = head;
        while (previous.next != null && previous.next.data != data) {
            previous = previous.next;
        }
        if (previous.next == null) {
            return false;
        }
        previous.next = previous.next.next;
        size--;
        return true;
    }

    public boolean deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        previous.next = previous.next.next;
        size--;
        return true;
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
