package math;

/**
 * @description:
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * 示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 * @author:      alex
 * @createTime:  2020/7/29 15:56
 * @version:     1.0
 */
public class Maximum {

    public int maximum(int a, int b) {
        long k = (long)a - (long)b;
        //取得符号位数
        int n = (int)(k >> 63);
        return (n + 1) * a - b * n;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = -2147483648;
        Maximum maximum = new Maximum();
        System.out.println(maximum.maximum(a, b));
        System.out.println(Integer.MAX_VALUE);
    }
}
