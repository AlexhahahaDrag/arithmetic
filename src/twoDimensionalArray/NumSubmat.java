package twoDimensionalArray;

/**
 *description:
 * 5454. 统计全 1 子矩形
 *  显示英文描述
 * 我的提交
 * 返回竞赛
 *
 * 通过的用户数
 * 630
 * 尝试过的用户数
 * 1006
 * 用户总通过次数
 * 634
 * 用户总提交次数
 * 1454
 * 题目难度
 * Medium
 * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *
 * 示例 1：
 * 输入：mat = [[1,0,1],
 *             [1,1,0],
 *             [1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 * 示例 2：
 * 输入：mat = [[0,1,1,0],
 *             [0,1,1,1],
 *             [1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * 示例 3：
 * 输入：mat = [[1,1,1,1,1,1]]
 * 输出：21
 * 示例 4：
 * 输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
 * 输出：5
 *
 * 提示：
 * 1 <= rows <= 150
 * 1 <= columns <= 150
 * 0 <= mat[i][j] <= 1
 *author:       alex
 *createDate:   2020/7/5 11:39
 *version:      1.0.0
 */
public class NumSubmat {

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            int num = 0;
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 1) {
                    num++;
                } else {
                    num = 0;
                }
                map[i][j] = num;
            }
        }
        int res = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, map[k][j]);
                    res += min;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}};
        NumSubmat numSubmat = new NumSubmat();
        System.out.println(numSubmat.numSubmat(mat));
    }
}
