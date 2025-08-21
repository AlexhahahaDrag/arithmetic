package twoDimensionalArray;

import java.util.Arrays;

/**
 * description:
 * 2965. 找出缺失和重复的数字
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 *
 * 任务是找出重复的数字a 和缺失的数字 b 。
 *
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 * 解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 * 示例 2：
 *
 * 输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出：[9,5]
 * 解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 *
 *
 * 提示：
 *
 * 2 <= n == grid.length == grid[i].length <= 50
 * 1 <= grid[i][j] <= n * n
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的任何成员都不相等。
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的两个成员相等。
 * 除上述的两个之外，对于所有满足1 <= x <= n * n 的 x ，都恰好存在一对 i, j 满足 0 <= i, j <= n - 1 且 grid[i][j] == x
 * author:       majf
 * createDate:   2024/5/31 9:01
 * version:      1.0.0
 */
public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int n = grid.length;
        int[] nums = new int[n * n + 1];
        for (int[] g : grid) {
            for (int j = 0; j < n; j++) {
                nums[g[j]]++;
            }
        }
        int a = 0, b = 0;
        for (int i = 1; i <= n * n; i++) {
            if (nums[i] == 0) {
                b = i;
            } else if (nums[i] == 2) {
                a = i;
            }
        }
        return new int[]{a, b};
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        int pow = 0;
        for (int[] g : grid) {
            for (int j = 0; j < n; j++) {
                sum += g[j];
                pow += g[j] * g[j];
            }
        }
        int sumN = 0;
        int powN = 0;
        for (int i = 1; i <= n * n; i++) {
            sumN += i;
            powN += i * i;
        }
        int aa = sumN - sum;
        int bb = powN - pow;
        int b = (bb - aa * aa) / (2 * aa);
        return new int[]{b, aa + b};
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 2, 3}, {4, 5, 5}, {7, 8, 9}}; // [5,6]
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};//[9,5]
        int[] res = new FindMissingAndRepeatedValues().findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(res));
        int[] res1 = new FindMissingAndRepeatedValues().findMissingAndRepeatedValues1(grid);
        System.out.println(Arrays.toString(res1));
    }
}
