package linearlist;

public class LinkedLinearList<T> implements LinearList<T> {
    private Node<T> mHead;
    private int mSize;

    public LinkedLinearList() {
        mHead = new Node<>(null);
    }

    @Override
    public boolean isEmpty() {
        return mHead.next == null;
    }

    /**
     * O(1)
     */
    @Override
    public int size() {
        return mSize;
    }

    /**
     * O(n)
     */
    @Override
    public void add(T obj) {
        Node<T> rear = mHead;
        while (rear.next != null) {
            rear = rear.next;
        }
        rear.next = new Node<>(obj);
        mSize++;
    }

    /**
     * O(n)
     */
    @Override
    public void add(int index, T obj) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index below zero, index is " + index);
        }
        Node<T> target = null;
        int i = 0;
        Node<T> current = mHead;
        while (current.next != null) {
            if (index == i) {
                target = current;
                break;
            }
            current = current.next;
            i++;
        }
        if (target != null) {
            Node<T> node = new Node<>(obj);
            node.next = target.next;
            target.next = node;
            mSize++;
        } else {
            throw new IndexOutOfBoundsException("index is " + index + ", list size is " + i);
        }
    }

    /**
     * O(n)
     */
    @Override
    public T find(int index) {
        int i = 0;
        Node<T> current = mHead;
        while (current.next != null) {
            if (index == i) {
                return current.next.data;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    /**
     * O(n)
     */
    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("index is " + index + ", list is empty");
        }
        if (index == 0) {
            Node<T> next = mHead.next;
            mHead.next = next.next;
            mSize--;
            return;
        }
        int i = 0;
        Node<T> current = mHead;
        while (current.next != null) {
            if (index == i) {
                Node<T> next = current.next;
                current.next = next.next;
                mSize--;
                return;
            }
            current = current.next;
            i++;
        }
    }

    /**
     * O(1)
     */
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
