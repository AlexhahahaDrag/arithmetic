package array;

/**
 * @Description: Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 *
 * Example 1:
 *
 * Input: {2,1,4,7,3,2,5}
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * Follow up:
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 * @Author:     alex
 * @CreateDate: 2019/7/25 17:40
 * @Version:    1.0
 *
 *
 * 0,1,2,3,4,5,4,3,2,1,0       11
 * 2,3                         0
 */
public class LongestMountainInArray {
    public static void main(String[] args) {
        LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
        int[] arr = {2,1,4,7,3,2,5,4,3,2,1,7,8,9,3,2,5,7,3,4,2};
        System.out.println(longestMountainInArray.longestMountain(arr));
    }
    public int longestMountain(int[] A) {
        int res = 0;
        for (int i = 1; i < A.length; ) {
            if (A[i] > A[i - 1]) {
                int j = i;
                while (j < A.length && A[j] > A[j - 1])
                    j++;
                if (j == A.length)
                    break;
                while (j < A.length && A[j] < A[j - 1])
                    j++;
                if (j - i > 1)
                    res = res >= j - i + 1 ? res : j - i + 1;
                i = j;
            } else
                i++;
        }
        return res;
    }
}
