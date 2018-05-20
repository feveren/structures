package stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private T[] mData;
    private int mSize;
    private int mCapacity;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
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
    public void push(T obj) {
        if (mData.length == mSize) {
            mCapacity *= 2;
            T[] old = mData;
            mData = (T[]) new Object[mCapacity];
            System.arraycopy(old, 0, mData, 0, mSize);
        }
        mData[mSize] = obj;
        mSize++;
    }

    @Override
    public T pop() {
        if (mSize == 0) {
            return null;
        }
        T result = mData[mSize - 1];
        mData[mSize - 1] = null;
        mSize--;
        return result;
    }

    @Override
    public T peek() {
        if (mSize == 0) {
            return null;
        }
        return mData[mSize - 1];
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
