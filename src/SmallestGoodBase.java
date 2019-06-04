import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * @Description: For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
 *
 * Now given a string representing n, you should return the smallest good base of n in string format.
 *
 * Example 1:
 *
 * Input: "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 *
 *
 * Example 2:
 *
 * Input: "4681"
 * Output: "8"
 * Explanation: 4681 base 8 is 11111.
 *
 *
 * Example 3:
 *
 * Input: "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 *
 *
 * Note:
 *
 * The range of n is [3, 10^18].
 * The string representing n is always valid and will not have leading zeros.
 * @Author:      alex
 * @CreateDate:  2019/4/23 14:09
 * @param
 * @return
 */
public class SmallestGoodBase {
    public static void main(String[] args) {
        System.out.println(smallestGoodBase("1000000000000000000"));
    }
    public static String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int p = (int)(Math.log(num + 1) / Math.log(2)); p >= 1; p--) { //p为最大长度，因为最小进制为2，最长就是/log（2）
            if ((1 << p) < num) { //num如果小就不可能是这个长度，跳过；因为二进制这是最小的了
                long k = helper(num, p);
                if (k != -1) return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1); //如果都没有就是直接-1的
    }
    private static long helper(long num, int p) {
        long l = 1, r = (long)(Math.pow(num, 1.0/p) + 1);
        while (l < r) {
            long mid = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i <= p; i++) { //注意此处是从0开始到第P 位的
                sum += cur;
                cur *= mid;
            }
            if (sum == num) return mid;
            else if (sum > num) r = mid;
            else l = mid + 1;
        }
        return -1;
    }
}

