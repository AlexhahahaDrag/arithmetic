package math;

/**
 * Description:
 * 878. 第 N 个神奇数字 显示英文描述
 * 用户通过次数29
 * 用户尝试次数116
 * 通过次数29
 * 提交次数401
 * 题目难度Hard
 * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
 *
 * 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 1, A = 2, B = 3
 * 输出：2
 * 示例 2：
 *
 * 输入：N = 4, A = 2, B = 3
 * 输出：6
 * 示例 3：
 *
 * 输入：N = 5, A = 2, B = 4
 * 输出：10
 * 示例 4：
 *
 * 输入：N = 3, A = 6, B = 4
 * 输出：8
 *1000000000
 * 40000
 * 40000
 *
 * 999720007
 *
 * 提示：
 *
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 * Author:      alex
 * CreateDate:  2019/12/16 14:00
 * Version:     1.0
 *
*/
public class NthMagicalNumber {

    public long nthMagicalNumber1(long N, long A, long B) {
        int inA = 0;
        int inB = 0;
        while (inA + inB < N) {
            long sa = A * (inA + 1);
            long sb = B * (inB + 1);
            if (sa == sb) {
                inA++;
                inB++;
                N++;
            } else if (sa > sb)
                inB++;
            else
                inA++;
        }
        return A * inA > B * inB ? A * inA : B * inB;
    }

    public int nthMagicalNumber(int N, long A, long B) {
        long su = A * B / gcd(A, B);
        long num = su / A + su / B  - 1;
        long a = N / num;
        long b = N % num;
        long c = nthMagicalNumber1(b, A , B);
        return (int)((su * a + c) % (Math.pow(10, 9) + 7));
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        NthMagicalNumber nthMagicalNumber = new NthMagicalNumber();
        int N = 1000000000;
        int A = 40000;
        int B = 40000;
        System.out.println(nthMagicalNumber.nthMagicalNumber(N, A, B));
    }
}
