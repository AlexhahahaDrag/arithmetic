package twoDimensionalArray;

/**
 * Description:
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * Author:      alex
 * CreateDate:  2020/6/5 12:51
 * Version:     1.0
 *
*/
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[]{};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[] res = new int[row * column];
        int sum = row * column;
        int curRow = 0;
        int curColumn = -1;
        int cur = 0;
        while(sum > 0) {
            while(curColumn + direction[index][1] >= 0 && curColumn + direction[index][1] < column
                    && curRow + direction[index][0] >= 0 && curRow + direction[index][0] < row
                    && !visited[curRow + direction[index][0]][curColumn + direction[index][1]]) {
                sum--;
                curColumn += direction[index][1];
                curRow += direction[index][0];
                visited[curRow][curColumn] = true;
                res[cur++] = matrix[curRow][curColumn];
            }
            index = (++index) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrder();
        int[] res = spiralOrder.spiralOrder(matrix);
        for (int i : res)
            System.out.print(i + "   ");
    }
}
