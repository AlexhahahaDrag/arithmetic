package twoDimensionalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *description:
 * 5269. 从栈中取出 K 个硬币的最大面值和
 * 一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 *
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 *
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：piles = [[1,100,3],[7,8,9]], k = 2
 * 输出：101
 * 解释：
 * 上图展示了几种选择 k 个硬币的不同方法。
 * 我们可以得到的最大面值为 101 。
 * 示例 2：
 *
 * 输入：piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
 * 输出：706
 * 解释：
 * 如果我们所有硬币都从最后一个栈中取，可以得到最大面值和。
 *
 *
 * 提示：
 *
 * n == piles.length
 * 1 <= n <= 1000
 * 1 <= piles[i][j] <= 105
 * 1 <= k <= sum(piles[i].length) <= 2000
 *author:       alex
 *createDate:   2022/3/27 15:22
 *version:      1.0.0
 */
public class MaxValueOfCoins {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        for (int i = 1; i <= piles.size(); i++) {
            int max = Math.min(piles.get(i - 1).size(), k);
            int[] maxArr = new int[max + 1];
            for (int j = 0; j < max; j++) {
                maxArr[j + 1] = maxArr[j] + piles.get(i - 1).get(j);
            }
            for (int kk = 1; kk <= k; kk++) {
                for (int l = 0; l <= Math.min(kk, max); l++) {
                    dp[i][kk] = Math.max(dp[i][kk], dp[i - 1][kk - l] + maxArr[l]);
                }
            }
        }
        return dp[piles.size()][k];
    }

    public static void main(String[] args) {
//        Integer[][] arr = {{100},{100},{100},{100},{100},{100},{1,1,1,1,1,1,700}};//706
//        int k = 7;
        Integer[][] arr = {{1,100,3},{7,8,9}};//706
        int k = 2;
        List<List<Integer>> piles = new ArrayList<>();
        for (Integer[] a : arr) {
            piles.add(Arrays.asList(a));
        }

        MaxValueOfCoins maxValueOfCoins = new MaxValueOfCoins();
        System.out.println(maxValueOfCoins.maxValueOfCoins(piles, k));
    }
}
