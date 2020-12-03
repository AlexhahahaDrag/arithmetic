package math;

/**
 * @description:
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 * @author:      alex
 * @createTime:  2020/12/3 17:42
 * @version:     1.0
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int ans = 0;
        int[] map = new int[n];
        for (int i = 2; i < n; i++) {
            if (map[i] == 0) {
                ans++;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i)
                        map[j] = 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 20;
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(n));
    }
}
