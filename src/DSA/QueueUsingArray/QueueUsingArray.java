package DSA.QueueUsingArray;

public class QueueUsingArray {

    private int[] data = new int[4];
    private int front = 0; // index of the first element
    private int size = 0;

    public void enqueue(int x) {
        if (size == data.length)
            grow();
        data[(front + size) % data.length] = x; // rear slot, wraps around
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        int val = data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int[] bigger = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            bigger[i] = data[(front + i) % data.length]; // unwrap in order
        }
        data = bigger;
        front = 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello from QueueUsingArray!");
    }
}
