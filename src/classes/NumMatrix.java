package classes;

/**
 * @description: 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * @author:      alex
 * @createTime:  2021/3/4 13:24 
 * @version:     1.0
 */
public class NumMatrix {

    private int[][] map;
//    public NumMatrix(int[][] matrix) {
//        for (int k = 0; k < matrix.length; k++) {
//            for (int l = 1; l < matrix[k].length; l++) {
//                matrix[k][l] += matrix[k][l - 1];
//            }
//        }
//        map = matrix;
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j] + "   ");
//            }
//            System.out.println();
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if (row1 < 0) {
//            row1 = 0;
//        }
//        if (col2 > map[0].length - 1) {
//            col2 = map[0].length - 1;
//        }
//        int sum = 0;
//        for (int i = row1; i <= row2 && i < map.length; i++) {
//            sum += map[i][col2] - (col1 <= 0 ? 0 : map[i][col1 - 1]);
//        }
//        return sum;
//    }
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int k = 1; k < matrix.length; k++) {
            for (int l = 1; l < matrix[k].length; l++) {
                matrix[k][l] += matrix[k][l - 1] + matrix[k - 1][l] - matrix[k - 1][l - 1];
            }
        }
        map = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (map == null || map.length == 0 || row1 >= map.length || col1 >= map[0].length) {
            return 0;
        }
        if (row2 >= map.length) {
            row2 = map.length - 1;
        }
        if (col2 >= map[0].length) {
            col2 = map[0].length - 1;
        }
        return map[row2][col2] - (row1 == 0 ? 0 : map[row1 - 1][col2]) - (col1 == 0 ? 0 : map[row2][col1 - 1]) + (row1 == 0 || col1 == 0 ? 0 : map[row1 - 1][col1 - 1]);
    }
}
