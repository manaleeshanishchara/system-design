package DSA.QueueUsingLinkedList;

public class QueueUsingLinkedList {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // front: dequeue here
    private Node tail; // rear: enqueue here
    private int size;

    public void enqueue(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node; // queue was empty
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null; // queue is now empty
        }
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Size: " + queue.size());      // 3
        System.out.println("Peek: " + queue.peek());      // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Empty: " + queue.isEmpty());   // true

        queue.enqueue(40); // tail must have been reset, or this breaks
        System.out.println("Peek after refill: " + queue.peek()); // 40

        try {
            queue.dequeue();
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
