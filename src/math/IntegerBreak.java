package math;

/**
 * @description:
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *  大于3的时候将整数分成3份的时候最大
 * @author:      alex
 * @createTime:  2020/7/30 13:50
 * @version:     1.0
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        int mod = n % 3;
        int num = n / 3;
        switch (mod) {
            case 0:
                return num * num * num;
            case 1:
                return num * num * (num + 1);
            default:
                return num * (num + 1) * (num + 1);
        }
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(10));
    }
}
