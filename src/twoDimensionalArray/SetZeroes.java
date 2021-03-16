package twoDimensionalArray;

/**
 *description:
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *author:       alex
 *createDate:  2020/2/18 19:34
 *version:      1.0.0
*/
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for(int k = 0; k < row.length; k++) {
            if(row[k] == 1) {
                for(int l = 0; l < matrix[0].length; l++) {
                    matrix[k][l] = 0;
                }
            }
        }

        for(int m = 0; m < column.length; m++) {
            if(column[m] == 1) {
                for(int n = 0; n < matrix.length; n++) {
                    matrix[n][m] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
