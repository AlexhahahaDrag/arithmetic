package classes;

import java.nio.BufferUnderflowException;

/**
 *description:  最小堆
 *author:       alex
 *createDate:  2020/4/13 21:38
 *version:      1.0.0
*/
public class BinaryHeap<AnyType extends Comparable<? super AnyType>>{

    private AnyType[] res = null;

    //默认大小9
    private final static int DEFAULT_CAPACITY = 10;

    private int currentSize = 0;

    public BinaryHeap() {
        res = (AnyType[]) new Comparable[DEFAULT_CAPACITY];
    }

    public BinaryHeap(int capacity) {
        res = (AnyType[]) new Comparable[capacity];
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        res = (AnyType[]) new Comparable[(items.length + 2) * 11 / 10];
        for (int i = 0; i < items.length; i++) {
            res[i + 1] = items[i];
        }
        buildHeap();
    }

    /**
     *description:新增时上滤
     *author:     alex
     *createDate:
     *@param:
     *@return:
    */
    public void insert(AnyType x) {
        if (currentSize == res.length - 1) {
            enlargeArray((res.length << 1) + 1);
        }
        int hole = ++currentSize;
        //避免空指针异常
        for (res[0] = x; x.compareTo(res[hole >> 1]) < 0; hole >>= 1) {
            res[hole] = res[hole >> 1];
        }
        res[hole] = x;
    }

    /**
     *description:
     *author:     alex
     *createDate:
     *@param:
     *@return:
    */
    public AnyType findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return res[1];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    /**
     *description: 删除最小值
     *author:     alex
     *createDate:
     *@param:
     *@return:
    */
    public void deleteMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        res[1] = res[currentSize--];
        percolateDown(1);;
    }

    /**
     *description:下滤
     *author:     alex
     *createDate:
     *@param:
     *@return:
    */

    private void percolateDown(int hole) {
        int child;
        AnyType cur = res[hole];
        for (; hole * 2 < currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && res[child + 1].compareTo(res[child]) < 0) {
                child++;
            }
            if (cur.compareTo(res[child]) >= 0) {
                res[hole] = res[child];
            } else {
                break;
            }
        }
        res[hole] = cur;
    }

    /**
     *description:扩容
     *author:     alex
     *createDate:
     *@param:
     *@return:
    */
    private void enlargeArray(int newSize) {
        AnyType[] resNew = (AnyType[]) new Comparable[newSize];
        for (int i = 1; i < res.length; i++) {
            resNew[i] = res[i];
        }
        res = resNew;
    }

    private void buildHeap() {
        for (int i = currentSize >> 1; i > 0; i--) {
            percolateDown(i);
        }
    }
}
