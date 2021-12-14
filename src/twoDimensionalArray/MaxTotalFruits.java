package twoDimensionalArray;

/**
 *description:
 * 2106. 摘水果
 * 在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 *
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 *
 * 返回你可以摘到水果的 最大总数 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
 * 输出：9
 * 解释：
 * 最佳路线为：
 * - 向右移动到位置 6 ，摘到 3 个水果
 * - 向右移动到位置 8 ，摘到 6 个水果
 * 移动 3 步，共摘到 3 + 6 = 9 个水果
 * 示例 2：
 *
 *
 * 输入：fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
 * 输出：14
 * 解释：
 * 可以移动最多 k = 4 步，所以无法到达位置 0 和位置 10 。
 * 最佳路线为：
 * - 在初始位置 5 ，摘到 7 个水果
 * - 向左移动到位置 4 ，摘到 1 个水果
 * - 向右移动到位置 6 ，摘到 2 个水果
 * - 向右移动到位置 7 ，摘到 4 个水果
 * 移动 1 + 3 = 4 步，共摘到 7 + 1 + 2 + 4 = 14 个水果
 * 示例 3：
 *
 *
 * 输入：fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
 * 输出：0
 * 解释：
 * 最多可以移动 k = 2 步，无法到达任一有水果的地方
 *
 *
 * 提示：
 *
 * 1 <= fruits.length <= 105
 * fruits[i].length == 2
 * 0 <= startPos, positioni <= 2 * 105
 * 对于任意 i > 0 ，positioni-1 < positioni 均成立（下标从 0 开始计数）
 * 1 <= amounti <= 104
 * 0 <= k <= 2 * 105
 *author:       alex
 *createDate:   2021/12/14 15:33
 *version:      1.0.0
 */
public class MaxTotalFruits {

    public int maxTotalFruits1(int[][] a, int s, int m) {
        int n = a.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + a[i][1];
        }
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            int low = i - 1, high = n - 1;
            while (low != high) {
                int mid = (low + high + 1) / 2;
                int cur = solve(a, i, mid, s);
                if (cur > m) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            int num = pre[high + 1] - pre[i];
            ret = Math.max(ret, num);
        }
        return ret;
    }

    private int solve(int[][] a, int L, int R, int s) {
        int ret;
        if (s >= a[R][0]) {
            ret = s - a[L][0];
        } else if (s <= a[L][0]) {
            ret = a[R][0] - s;
        } else {
            ret = a[R][0] - a[L][0] + Math.min(s - a[L][0], a[R][0] - s);
        }
        return ret;
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ret = 0;
        int n = fruits.length;
        int[] map = new int[n +1];
        for (int i = 0; i < n; i++) {
            map[i + 1] = map[i] + fruits[i][1];
        }
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - 1;
            while(l != r) {
                int mid = l + (r - l + 1 >> 1);
                int cur = findLen(fruits, i, mid, startPos);
                if (cur > k) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            ret = Math.max(ret, map[r + 1] - map[i]);
        }
        return ret;
    }

    private int findLen(int[][] fruit, int l, int r, int s) {
        if (s >= fruit[r][0]) {
            return s - fruit[l][0];
        } else if (s <= fruit[l][0]) {
            return fruit[r][0] - s;
        } else {
            return fruit[r][0] - fruit[l][0] + Math.min(s - fruit[l][0], fruit[r][0] - s);
        }
    }

    public static void main(String[] args) {
        int[][] fruits = {{0,9}, {4,1}, {5,7}, {6,2}, {7,4}, {10,9}};
        int startPos = 5;
        int k = 4;
        MaxTotalFruits maxTotalFruits = new MaxTotalFruits();
        System.out.println(maxTotalFruits.maxTotalFruits(fruits, startPos, k));
    }
}
