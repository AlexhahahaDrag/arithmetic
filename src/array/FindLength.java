package array;

/**
 * Description:
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * Author:      alex
 * CreateDate:  2020/7/1 12:26
 * Version:     1.0
 *
*/
public class FindLength {

    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        int[][] map = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                map[i][j] = A[i] == B[j] ? map[i + 1][j + 1] + 1 : 0;
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {0,0,0,0,0,0,1,0,0,0};
        int[] B = {0,0,0,0,0,0,0,1,0,0};
        FindLength findLength = new FindLength();
        System.out.println(findLength.findLength(A, B));
    }
}
