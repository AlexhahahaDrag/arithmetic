package twoDimensionalArray;

/**
 *description:
 * 提交记录
 * 6072. 转角路径的乘积中最多能有几个尾随零
 * 给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。
 *
 * 转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；反之亦然。当然，同样不能访问之前已经访问过的单元格。
 *
 * 一条路径的 乘积 定义为：路径上所有值的乘积。
 *
 * 请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。
 *
 * 注意：
 *
 * 水平 移动是指向左或右移动。
 * 竖直 移动是指向上或下移动。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]
 * 输出：3
 * 解释：左侧的图展示了一条有效的转角路径。
 * 其乘积为 15 * 20 * 6 * 1 * 10 = 18000 ，共计 3 个尾随零。
 * 可以证明在这条转角路径的乘积中尾随零数目最多。
 *
 * 中间的图不是一条有效的转角路径，因为它有不止一个弯。
 * 右侧的图也不是一条有效的转角路径，因为它需要重复访问已经访问过的单元格。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[4,3,2],[7,6,1],[8,8,8]]
 * 输出：0
 * 解释：网格如上图所示。
 * 不存在乘积含尾随零的转角路径。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= grid[i][j] <= 1000
 *author:       alex
 *createDate:   2022/4/18 6:07
 *version:      1.0.0
 */
public class MaxTrailingZeros {

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //预处理1000中各个数包含的2、5的个数
        int[][] res = num1000();
        //查询grid数组行列前缀和中各个数字包含的2、5个数
        int[][][] rowSum = new int[m][n + 1][2];
        int[][][] columnSum = new int[n][m + 1][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                rowSum[i][j + 1][0] = rowSum[i][j][0] + res[grid[i][j]][0];
                rowSum[i][j + 1][1] = rowSum[i][j][1] + res[grid[i][j]][1];
                columnSum[j][i + 1][0] = columnSum[j][i][0] + res[grid[i][j]][0];
                columnSum[j][i + 1][1] = columnSum[j][i][1] + res[grid[i][j]][1];
            }
        }
        int ant = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //左上
                int leftUp = Math.min(rowSum[i][j + 1][0] + columnSum[j][i][0],
                        rowSum[i][j + 1][1] + columnSum[j][i][1]);
                ant = Math.max(leftUp, ant);
                //左下
                int leftDown = Math.min(rowSum[i][j][0] + columnSum[j][m][0] - columnSum[j][i][0],
                        rowSum[i][j][1] + columnSum[j][m][1] - columnSum[j][i][1]);
                ant = Math.max(leftDown, ant);
                //右上
                int rightUp = Math.min(rowSum[i][n][0] - rowSum[i][j][0] + columnSum[j][i][0],
                        rowSum[i][n][1] - rowSum[i][j][1] + columnSum[j][i][1]);
                ant = Math.max(rightUp, ant);
                //右下
                int rightDown = Math.min(rowSum[i][n][0] - rowSum[i][j][0] + columnSum[j][m][0] - columnSum[j][i + 1][0],
                        rowSum[i][n][1] - rowSum[i][j][1] + columnSum[j][m][1] - columnSum[j][i + 1][1]);
                ant = Math.max(rightDown, ant);
            }
        }
        return ant;
    }

    private int[][] num1000() {
        int[][] res = new int[1001][2];
        for(int i = 2; i <= 1000; i++) {
            if(i % 2 == 0) {
                res[i][0] = res[i / 2][0] + 1;
            }
            if(i % 5 == 0) {
                res[i][1] = res[i / 5][1] + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[][] grid = {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};//3
//        int[][] grid = {{10, 6, 15}};//2
        int[][] grid = {{10}, {6}, {15}};//2
        MaxTrailingZeros maxTrailingZeros = new MaxTrailingZeros();
        System.out.println(maxTrailingZeros.maxTrailingZeros(grid));
    }
}
