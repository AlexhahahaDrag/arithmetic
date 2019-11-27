package math;

/**
 * @Description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @Author:     alex
 * @CreateDate: 2019/11/27 16:04
 * @Version:    1.0
 *
*/
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        return pow(x, n);
    }
    private double pow(double x, long n) {
        if (n != 1 && n != -1) {
            if ( (n & 1) == 1)
                return pow(x * x, n >> 1) * x;
            else
                return pow(x * x, n >> 1);
        } else
            return n == 1 ? x : 1 / x;
    }

    public static void main(String[] args) {
        System.out.println((-3) & 1);
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.000, -2147483648));
    }
}
