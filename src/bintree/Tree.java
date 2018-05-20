package bintree;

public interface Tree<T> {
    boolean isEmpty();

    int size();

    void put(T data);

    void remove(T data);
}
