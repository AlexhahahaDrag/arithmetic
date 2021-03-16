package array;

import java.util.Arrays;

/**
 * @Description:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @Author:     alex
 * @CreateDate: 2019/11/25 10:13
 * @Version:    1.0
 *
*/
public class MinStack {

    private int min = 0;

    private int[] store;

    private int size;

    private int current = -1;
    /** initialize your data structure here. */
    public MinStack() {
        store = new int[1];
        size = 1;
    }

    public void push(int x) {
        if(current + 1 >= size) {
            reset();
        }
        store[++current] = x;
        if (x < store[min]) {
            min = current;
        }
    }

    public void pop() {
        if(min == current) {
            min = 0;
            for(int i = 1; i < current - 1; i++) {
                if (store[i] < min) {
                    min = i;
                }
            }
        }
        current--;
    }

    public int top() {
        return store[current];
    }

    public int getMin() {
        return store[min];
    }

    private void reset() {
        size <<= 1;
        int[] storeMore = Arrays.copyOf(store, size);
        store = storeMore;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
