package array;

/**
 * @description:
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * @author:      alex
 * @createTime:  2020/10/16 9:37
 * @version:     1.0
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int start = 0;
        if(A[0] >= 0) {
            for(int i : A) {
                res[start++] = i * i;
            }
            return res;
        }
        int end = A.length - 1;
        if(A[len - 1] <= 0) {
            for(int i : A) {
                res[end--] = i * i;
            }
            return res;
        }
        int index = len - 1;
        while(start <= end) {
            if (A[start] * A[start] >= A[end] * A[end]) {
                res[index--] = A[start] * A[start];
                start++;
            } else {
                res[index--] = A[end] * A[end];
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-4,-1,0,3,10};
        SortedSquares sortedSquares = new SortedSquares();
        System.out.println(sortedSquares.sortedSquares(A));
    }
}
