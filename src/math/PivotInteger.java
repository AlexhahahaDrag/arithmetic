package math;

/**
 * @description:
 * 6245. 找出中枢整数
 * 简单
 * 3
 * 相关企业
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 *
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 * @author: alex
 * @createDate: 2022/11/27 20:51
 * @version: 1.0.0
 */
public class PivotInteger {

    public int pivotInteger1(int n) {
        int l = 1;
        int r = n;
        int ls = l;
        int rs = n;
        while(l < r) {
            if (ls < rs) {
                ls += ++l;
            } else {
                rs += --r;
            }
        }
        return ls == rs ? l : -1;
    }

    public int pivotInteger(int n) {
        int l = 1;
        int r = n;
        int ls = l;
        int rs = n;
        while(l < r) {
            if (ls < rs) {
                ls += ++l;
            } else {
                rs += --r;
            }
        }
        return ls == rs ? l : -1;
    }

    public static void main(String[] args) {
        int n = 8;
        PivotInteger pivotInteger = new PivotInteger();
        System.out.println(pivotInteger.pivotInteger1(n));
        System.out.println(pivotInteger.pivotInteger(n));
    }
}
