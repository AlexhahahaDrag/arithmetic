/**
 * @Description: Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 *
 * After this process, we have some array B.
 *
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 * Example 2:
 *
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 * Example 3:
 *
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 * @Author:      alex
 * @CreateDate:  2019/5/7 16:51
 * @param
 * @return
*/
public class SmallestRangeI {
    public static void main(String[] args) {
        int[] A={1,3,6};
        System.out.println(smallestRangeI(A,3));
    }
    public static int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            if(x<min) {
                min = x;
            } else if(x>max) {
                max = x;
            }
        }
        return max-min-2*K < 0 ? 0 : max-min-2*K;
    }
}
