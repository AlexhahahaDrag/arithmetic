package twoDimensionalArray;

/**
 * @Description:
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
{
 *   {1,   4,  7, 11, 15},
 *   {2,   5,  8, 12, 19},
 *   {3,   6,  9, 16, 22},
 *   {10, 13, 14, 17, 24},
 *   {18, 21, 23, 26, 30}
 * }
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 * @Author:     alex
 * @CreateDate: 2019/11/21 17:07
 * @Version:    1.0
 *
*/
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5,  8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 5));
    }
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return find(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    private boolean find(int[][] matrix, int x, int y, int xx, int yy, int target) {
        if (x <= xx && y <= yy) {
            int midx = x + xx >> 1;
            int midy = y + yy >> 1;
            if (matrix[midx][midy] == target) {
                return true;
            } else if (matrix[midx][midy] < target) {
                return find(matrix, midx + 1, y, xx, yy, target) || find(matrix, x, midy + 1, xx, yy, target);
            } else {
                return find(matrix, x, y, midx - 1, yy, target) || find(matrix, x, y, xx, midy - 1, target);
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private boolean search(int[][] matrix, int xs, int xe, int ys, int ye, int target) {
        if(xs > xe || ys > ye) {
            return false;
        }
        int xmid = xs + (xe - xs >> 1);
        int ymid = ys + (ye - ys >> 1);
        if(matrix[xmid][ymid] == target) {
            return true;
        } else if (target < matrix[xmid][ymid]) {
            return search(matrix, xs, xmid - 1, ys, ye, target) || search(matrix, xs, xe, ys, ymid - 1, target);
        } else {
            return search(matrix, xmid + 1, xe, ys, ye, target) || search(matrix, xs, xe, ymid + 1, ye, target);
        }
    }
}
