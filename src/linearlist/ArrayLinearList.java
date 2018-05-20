package linearlist;

import java.util.Arrays;

public class ArrayLinearList<T> implements LinearList<T> {
    private T[] mData;
    private int mSize;
    private int mCapacity;

    public ArrayLinearList() {
        this(10);
    }

    public ArrayLinearList(int capacity) {
        this.mCapacity = capacity;
        this.mData = (T[]) new Object[capacity];
    }

    /**
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return mSize <= 0;
    }

    /**
     * O(1)
     */
    @Override
    public int size() {
        return mSize;
    }

    /**
     * O(1)
     */
    @Override
    public void add(T obj) {
        if (mData.length == mSize) {
            mCapacity *= 2;
            T[] old = mData;
            mData = (T[]) new Object[mCapacity];
            System.arraycopy(old, 0, mData, 0, mSize);
        }
        mData[mSize] = obj;
        mSize += 1;
    }

    /**
     * O(n)
     */
    @Override
    public void add(int index, T obj) {
        if (index >= mSize) {
            throw new IndexOutOfBoundsException("index is " + index + ", list size is " + mSize);
        }
        if (mData.length == mSize) {
            T[] old = mData;
            mCapacity *= 2;
            mData = (T[]) new Object[mCapacity];
            System.arraycopy(old, 0, mData, 0, index + 1);
        }
        System.arraycopy(mData, index, mData, index + 1, mSize - index);
        mData[index] = obj;
        mSize += 1;
    }

    /**
     * O(1)
     */
    @Override
    public T find(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException("index is " + index + ", list size is " + mSize);
        }
        return mData[index];
    }

    /**
     * O(1)
     */
    @Override
    public void remove(int index) {
        if (index >= mSize) {
            throw new IndexOutOfBoundsException("index is " + index + ", list size is " + mSize);
        }
        if (index < mSize - 1) {
            System.arraycopy(mData, index + 1, mData, index, mSize - index - 1);
        }
        mData[mSize - 1] = null;
        mSize -= 1;
    }

    /**
     * O(1)
     */
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
