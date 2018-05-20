package linearlist;

public interface LinearList<T> {
    boolean isEmpty();

    int size();

    void add(T obj);

    void add(int index, T obj);

    T find(int index);

    void remove(int index);

    void clear();
}
