package queue;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {
    private T[] mData;
    private int mSize;
    private int mCapacity;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.mCapacity = capacity;
        mData = (T[]) new Object[mCapacity];
    }

    @Override
    public boolean isEmpty() {
        return mSize == 0;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public void offer(T obj) {
        if (mData.length == mSize) {
            mCapacity *= 2;
            T[] old = mData;
            mData = (T[]) new Object[mCapacity];
            System.arraycopy(old, 0, mData, 0, mSize);
        }
        mData[mSize] = obj;
        mSize++;
    }

    /**
     * O(n)，每次取数据，需要把数据整体前移一位
     */
    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T head = mData[0];
        System.arraycopy(mData, 1, mData, 0, mSize - 1);
        mData[mSize - 1] = null;
        mSize--;
        return head;
    }

    @Override
    public T peek() {
        return mData[0];
    }

    @Override
    public void clear() {
        mData = (T[]) new Object[mCapacity];
        mSize = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(mData) + ", size = " + mSize;
    }
}
