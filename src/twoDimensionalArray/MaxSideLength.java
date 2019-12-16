package twoDimensionalArray;

/**
 * Description:
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 *
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 *
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 * 示例 3：
 *
 * 输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * 输出：3
 * 示例 4：
 *
 * 输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/16 10:28
 * Version:     1.0
 *
*/
public class MaxSideLength {

    int max = 0;
    int sum = 0;
    public int maxSideLength(int[][] mat, int threshold) {
        for (int i = 0; i + max < mat.length; i++) {
            for (int j = 0; j + max < mat[i].length; j++) {
                find (mat, i, j, sum, max, threshold);
            }
        }
        return max;
    }

    private void find(int[][] mat, int i, int j, int sum, int max, int threshold) {
        if (i + max >= mat.length || j + max >= mat[0].length)
            return;
        int xIn = 0;
        int tSum = 0;
        if (i - 1 > 0) {
            int yIn = 0;
            tSum = sum;
            while (yIn < max)
                tSum -= mat[i - 1][j + yIn] + mat[i + max][j + yIn];
            if (tSum > threshold)
                sum = tSum;
            else {
                while (judge(mat, i, j, sum, max + 1, threshold))
                    max++;
            }
        } else {
            for (int a = i; a <= i + max; a++)
                for(int b = j; b <= j + max; b++)
                    tSum += mat[a][b];
                sum = tSum;
            if(tSum <= threshold) {
                while (judge(mat, i, j, sum, max + 1, threshold))
                    max++;
            }
        }
    }

    private boolean judge(int[][] mat, int i, int j, int sum, int max, int threshold) {
        int tSum = sum;
        if (i + max >= mat.length || j + max >= mat[0].length)
            return false;
        for (int a = i; a <= i + max; i++)
            tSum += mat[a][j + max];
        if (tSum > threshold)
            return false;
        for(int b = j; b < j + max; j++)
            tSum += mat[i + max][b];
        if (tSum <= threshold) {
            sum = tSum;
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        MaxSideLength maxSideLength = new MaxSideLength();
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        System.out.println(maxSideLength.maxSideLength(mat, threshold));
    }
}
