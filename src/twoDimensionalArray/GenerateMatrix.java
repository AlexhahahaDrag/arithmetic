package twoDimensionalArray;

/**
 * @description:
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * @author:      alex
 * @createTime:  2021/3/16 12:24
 * @version:     1.0
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int[][] diction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cur = 1;
        int dic = 0;
        int row = 0;
        int column = -1;
        while(cur <= n * n) {
            while(row + diction[dic][0] >= 0 && row + diction[dic][0] < n && column + diction[dic][1] >= 0 && column + diction[dic][1] < n &&
                    map[row + diction[dic][0]][column + diction[dic][1]] == 0) {
                row += diction[dic][0];
                column += diction[dic][1];
                map[row][column] = cur++;
            }
            dic++;
            dic %= 4;
        }
        return map;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] res = generateMatrix.generateMatrix(-1);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + ",");
            }
            System.out.println();
        }
    }
}
