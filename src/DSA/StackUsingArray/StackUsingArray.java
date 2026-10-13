package DSA.StackUsingArray;

import java.util.Arrays;

public class StackUsingArray {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] stack;
    private int size;

    public StackUsingArray() {
        this(DEFAULT_CAPACITY);
    }

    public StackUsingArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }
        this.stack = new int[capacity];
        this.size = 0;
    }

    public void push(int val) {
        if (size == stack.length) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[size++] = val;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return stack[--size];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(2);

        stack.push(10);
        stack.push(20);
        stack.push(30); // triggers resize

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
