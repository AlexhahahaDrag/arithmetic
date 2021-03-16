package twoDimensionalArray;

/**
 *description:
 * 5383. 给 N x 3 网格图涂色的方案数 显示英文描述
 * 用户通过次数322
 * 用户尝试次数375
 * 通过次数338
 * 提交次数500
 * 题目难度Hard
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 *
 * 给你网格图的行数 n 。
 *
 * 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：12
 * 解释：总共有 12 种可行的方法：
 *
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：54
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：246
 * 示例 4：
 *
 * 输入：n = 7
 * 输出：106494
 * 示例 5：
 *
 * 输入：n = 5000
 * 输出：30228214
 *
 *
 * 提示：
 *
 * n == grid.length
 * grid[i].length == 3
 * 1 <= n <= 5000
 *author:       alex
 *createDate:  2020/4/12 11:35
 *version:      1.0.0      
*/
public class NumOfWays {

    public int numOfWays(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 12;
        }
        long aba = 6;
        long abc = 6;
        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            long newAba = (aba << 1) % mod + (abc << 1) % mod;
            long newAbc = (abc * 3) % mod + (aba << 1) % mod;
            aba = newAba;
            abc = newAbc;
        }
        return (int)((abc + aba) % mod);
    }

    public static void main(String[] args) {
        NumOfWays numOfWays = new NumOfWays();
        System.out.println(numOfWays.numOfWays(17));
    }
}
