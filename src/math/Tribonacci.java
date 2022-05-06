package math;

/**
 *description:
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *author:       alex
 *createDate:   2022/2/10 17:42
 *version:      1.0.0
 */
public class Tribonacci {

    public int tribonacci(int n) {
        switch (n) {
            case 0 :
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                int a = 0;
                int b = 1;
                int c = 1;
                int d = 0;
                while(n-- > 2) {
                    d = a + b + c;
                    a = b;
                    b = c;
                    c = d;
                }
                return d;
        }
    }

    public static void main(String[] args) {
        int n = 25;//1389537
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(n));
    }
}