package queue;

public interface Queue<T> {
    boolean isEmpty();

    int size();

    void offer(T obj);

    T poll();

    T peek();

    void clear();
}
