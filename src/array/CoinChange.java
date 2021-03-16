package array;

import java.util.Arrays;

/**
 *description:
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *author:       alex
 *createDate:   2020/10/26 22:22
 *version:      1.0.0
 */
public class CoinChange {

    public int coinChange1(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && res[i - coins[j]] < Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i - coins[j]] + 1, res[i]);
                }
            }
        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

    private int min = Integer.MIN_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && res[i - coins[j]] < Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i - coins[j]] + 1, res[i]);
                }
            }
        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

    private void dfs(int[] coins, int i, int count, int sum, int amount) {
        if (sum == amount) {
            min = Math.min(min, count);
            return;
        }
        if (count >= min) {
            return;
        }

    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1 };
        int amount = 27;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
    }
}
