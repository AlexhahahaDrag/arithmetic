package math;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *author:       alex
 *createDate:   2021/11/19 12:47
 *version:      1.0.0
 */
public class IntegerReplacement {

    private Map<Long, Integer> map;
    public int integerReplacement(int n) {
        map = new HashMap<>();
        return find(n);
    }

    private int find(long n) {
        if(n == 1) {
            return 0;
        }
        int num = 0;
        if (map.get(n) != null) {
            return map.get(n);
        }
        if((n & 1) == 0) {
            num += find(n >> 1) + 1;
        } else {
            num += Math.min(find(n + 1), find(n - 1)) + 1;
        }
        map.put(n, num);
        return num;
    }

    public static void main(String[] args) {
        int n = 2147483647;
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(integerReplacement.integerReplacement(n));
    }
}
