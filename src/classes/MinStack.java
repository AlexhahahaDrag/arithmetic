package classes;

import java.util.Stack;

/**
 * @description:
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa7r55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/18 17:14
 * @version:     1.0
 */
public class MinStack {

//    int[] res = null;
//
//    int size = 0;
//
//    int min = -1;
//    /** initialize your data structure here. */
//    public MinStack() {
//        res = new int[10];
//    }
//
//    public void push(int x) {
//        if(size == res.length)
//            changeMore();
//        if(min == -1 || x < res[min])
//            min = size;
//        res[size++] = x;
//    }
//
//    public void pop() {
//        size--;
//        if(size == min)
//            findMin();
//    }
//
//    private void findMin() {
//        min = 0;
//        for(int i = 1; i < size; i++)
//            if(res[min] > res[i])
//                min = i;
//    }
//
//    public int top() {
//        if(size < 0)
//            return -1;
//        return res[size - 1];
//    }
//
//    public int getMin() {
//        if(min == -1)
//            return -1;
//        return res[min];
//    }
//
//    private void changeMore() {
//        int[] more = new int[res.length << 1];
//        for(int i = 0; i < size; i++)
//            more[i] = res[i];
//        res = more;
//    }
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.add(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(7);
        minStack.push(1);
        minStack.push(5);
        minStack.push(7);
        minStack.push(6);
        minStack.push(2);
        minStack.push(0);
        minStack.push(1);
//        minStack.push(512);
//        minStack.push(-1024);
//        minStack.push(-1024);
        System.out.println(minStack.min());   //返回 -3.
        minStack.pop();
        System.out.println(minStack.min());   //返回 -3.
        minStack.pop();
        System.out.println(minStack.min());   //返回 -3.
        minStack.pop();
        System.out.println(minStack.min());   //返回 -3.
        minStack.pop();
    }
}
