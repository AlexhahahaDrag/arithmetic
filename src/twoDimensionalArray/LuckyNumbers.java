package twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 5356. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 *author:       alex
 *createDate:  2020/3/15 12:39
 *version:      1.0.0
*/
public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return res;
        int[] column = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int cur = 0;
            for(int j = 1; j < matrix[i].length; j++) {
                if(min > matrix[i][j]) {
                    min = matrix[i][j];
                    cur = j;
                } else if(min == matrix[i][j])
                    cur = -1;
            }
            column[i] = cur;
        }

        for(int k = 0; k < column.length; k++) {
            if (column[k] == -1)
                continue;
            boolean flag = true;
            for(int l = 0; l < matrix.length; l++) {
                if(l != k && matrix[k][column[k]] <= matrix[l][column[k]]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                res.add(matrix[k][column[k]]);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{76618,42558,65788,20503,29400,54116}};
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        System.out.println(luckyNumbers.luckyNumbers(matrix));
    }
}
