package queue;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> mHead;
    private int mSize;

    public LinkedQueue() {
        this.mHead = new Node<>(null);
    }

    @Override
    public boolean isEmpty() {
        return mHead.next == null;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public void offer(T obj) {
        Node<T> current = mHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(obj);
        mSize++;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        Node<T> queueHead = mHead.next;
        mHead.next = queueHead.next;
        mSize--;
        return queueHead.data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return mHead.next.data;
    }

    @Override
    public void clear() {
        mHead.next = null;
        mSize = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        Node<T> current = mHead;
        while (current.next != null) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(current.next.data);
            current = current.next;
            i++;
        }
        return "[" + builder.toString() + "]";
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
