package math;

/**
 *description:  400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 *
 *
 *
 * 方法二：直接计算
 * 方法一使用二分查找得到第 nn 位数字所在整数是几位数。也可以不使用二分查找，而是直接根据规律计算。
 *
 * 已知 xx 位数共有 9 \times 10^{x - 1}9×10
 * x−1
 *   个，所有 xx 位数的位数之和是 x \times 9 \times 10^{x - 1}x×9×10
 * x−1
 *  。使用 dd 和 \textit{count}count 分别表示当前遍历到的位数和当前位数下的所有整数的位数之和，初始时 d = 1d=1，\textit{count} = 9count=9。每次将 nn 减去 d \times \textit{count}d×count，然后将 dd 加 11，将 \textit{count}count 乘以 1010，直到 n \le d \times \textit{count}n≤d×count，此时的 dd 是目标数字所在整数的位数，nn 是所有 dd 位数中从第一位到目标数字的位数。
 *
 * 为了方便计算目标数字，使用目标数字在所有 dd 位数中的下标进行计算，下标从 00 开始计数。令 \textit{index} = n - 1index=n−1，则 \textit{index}index 即为目标数字在所有 dd 位数中的下标，\textit{index}index 的最小可能取值是 00。
 *
 * 得到下标 \textit{index}index 之后，即可使用方法一的做法得到无限整数序列中的第 nn 位数字。
 *
 * JavaC#C++JavaScriptGolangPython3
 *
 * class Solution {
 *     public int findNthDigit(int n) {
 *         int d = 1, count = 9;
 *         while (n > (long) d * count) {
 *             n -= d * count;
 *             d++;
 *             count *= 10;
 *         }
 *         int index = n - 1;
 *         int start = (int) Math.pow(10, d - 1);
 *         int num = start + index / d;
 *         int digitIndex = index % d;
 *         int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
 *         return digit;
 *     }
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/nth-digit/solution/di-n-wei-shu-zi-by-leetcode-solution-mdl2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *author:       alex
 *createDate:   2021/11/30 10:49
 *version:      1.0.0
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        //当前位数的数的个数
        int nine = 9;
        //数的位数
        int digit = 1;
        //查询当前位所在的范围
        while(n > (long)nine * digit) {
            n -= nine * digit;
            nine *= 10;
            digit++;
        }
        //获取位数所在的数字
        int cur = (int) (Math.pow(10, digit - 1) + (n - 1) / digit);
        //获取位数所在数字的位数
        int digitIndex = (n - 1) % digit;
        int res = (cur / (int)(Math.pow(10, digit - digitIndex - 1))) % 10;
        return res;
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(2147483647));
    }
}
