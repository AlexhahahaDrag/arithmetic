package twoDimensionalArray;

/**
 *description:
 *
 *面试题47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *author:       alex
 *createDate:  2020/2/23 10:19
 *version:      1.0.0
*/
public class MaxValue {

    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] += Math.max((i - 1 < 0 ? 0 : grid[i - 1][j]), (j - 1 < 0 ? 0 : grid[i][j - 1]));
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(grid));
    }
}
