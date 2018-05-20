package stack;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> mHead;
    private int mSize;

    public LinkedStack() {
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
    public void push(T obj) {
        Node<T> next = mHead.next;
        Node<T> node = new Node<>(obj);
        node.next = next;
        mHead.next = node;
        mSize++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node<T> rear = mHead.next;
        mHead.next = rear.next;
        mSize--;
        return rear.data;
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
