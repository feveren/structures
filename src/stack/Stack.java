package stack;

public interface Stack<T> {
    boolean isEmpty();

    int size();

    void push(T obj);

    T pop();

    T peek();

    void clear();
}
