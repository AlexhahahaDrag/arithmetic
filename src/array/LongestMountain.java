package array;

/**
 *description:
 * 845. 数组中的最长山脉 显示英文描述
 * 题目难度Medium
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *author:       alex
 *createDate:  2020/2/4 13:46
 *version:      1.0.0      
*/
public class LongestMountain {

    public int longestMountain(int[] A) {
        int num = 0;
        int max = 0;
        boolean upper = false;
        boolean lower = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (upper)
                    num++;
                else {
                    upper = true;
                    lower = false;
                    num = 2;
                }
            } else if (A[i] > A[i + 1]) {
                if (upper) {
                    lower = true;
                    upper = false;
                }
                if (lower)
                    num++;
                max = Math.max(num, max);
            } else {
                upper = false;
                lower = false;
                num = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestMountain longestMountain = new LongestMountain();
        int[] A = {3,2};
        System.out.println(longestMountain.longestMountain(A));
    }
}
