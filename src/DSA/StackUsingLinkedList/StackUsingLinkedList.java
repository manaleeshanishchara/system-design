package DSA.StackUsingLinkedList;

public class StackUsingLinkedList {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // top of the stack
    private int size;

    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Size: " + stack.size());   // 3
        System.out.println("Peek: " + stack.peek());   // 30
        System.out.println("Pop: " + stack.pop());     // 30
        System.out.println("Pop: " + stack.pop());     // 20
        System.out.println("Pop: " + stack.pop());     // 10
        System.out.println("Empty: " + stack.isEmpty()); // true

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
