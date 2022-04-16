package math;

/**
 *description:
 * 479最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 *
 *
 *
 * 示例 1:
 *
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 *
 * 输入： n = 1
 * 输出： 9
 *
 *
 * 提示:
 *
 * 1 <= n <= 8
 *author:       alex
 *createDate:   2022/4/16 9:40
 *version:      1.0.0
 */
public class LargestPalindrome {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        long max = (long) Math.pow(10, n) - 1;
        long min = (long) Math.pow(10, n - 1);
        long res;
        for(long j = max; j >= min; j--) {
            res = getPalindrome(j);
            for(long i = max; i * i >= res; i--) {
                if (res % i == 0) {
                    return (int)( res % 1337);
                }
            }
        }
        return -1;
    }

    private long getPalindrome(long i) {
        long res = i;
        while(i > 0) {
            res = res * 10 + i % 10;
            i /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        LargestPalindrome largestPalindrome = new LargestPalindrome();
        System.out.println(largestPalindrome.largestPalindrome(n));
    }
}
