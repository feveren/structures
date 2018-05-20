package queue;

/**
 * 环形队列，数组实现
 * [0, 1, 2, 3, 4, 5, null]
 * mFrontPointer = 0, mRearPointer = 5
 * [7, null, 2, 3, 4, 5, 6]
 * mFrontPointer = 2, mRearPointer = 0
 */
//public class CircleArrayQueue<T> implements Queue<T> {
//    private T[] mData;
//    private int mFrontPointer = -1, mRearPointer;
//    private int mCapacity;
//
//    public CircleArrayQueue() {
//        this(10);
//    }
//
//    public CircleArrayQueue(int capacity) {
//        this.mCapacity = capacity;
//        mData = (T[]) new Object[mCapacity];
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return mSize == 0;
//    }
//
//    @Override
//    public int size() {
//        return mSize;
//    }
//
//    @Override
//    public void offer(T obj) {
//        if (mData.length == mRearPointer) {
//            mCapacity *= 2;
//            T[] old = mData;
//            mData = (T[]) new Object[mCapacity];
//            System.arraycopy(old, 0, mData, 0, mRearPointer);
//        }
//        mData[mRearPointer] = obj;
//        mRearPointer++;
//    }
//
//    /**
//     * O(n)，每次取数据，需要把数据整体前移一位
//     */
//    @Override
//    public T poll() {
//        if (isEmpty()) {
//            return null;
//        }
//        T head = mData[0];
//        System.arraycopy(mData, 1, mData, 0, mSize - 1);
//        return head;
//    }
//
//    @Override
//    public T peek() {
//        return mData[0];
//    }
//
//    @Override
//    public void clear() {
//        mData = (T[]) new Object[mCapacity];
//        mSize = 0;
//    }
//}
