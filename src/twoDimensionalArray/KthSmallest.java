package twoDimensionalArray;

/**
 * Description:
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2020/7/2 12:33
 * Version:     1.0
 *
*/
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while(left < right) {
            int mid = left + (right - left >> 1);
            int res = findNum(matrix, mid, n);
            if (res < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findNum(int[][] matrix, int mid, int n) {
        int res = 0;
        int j = 0;
        for (int i = n - 1; j < n &&  i >= 0;) {
            if (matrix[j][i] <= mid) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while(left < right) {
            int mid = left + (right - left >> 1);
            if (findNum1(matrix, mid, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean findNum1(int[][] matrix, int mid, int n, int k) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {1, 3}};
        int k = 3;
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(matrix, k));
    }
}
