package math;
/**
 * @Description: Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 * @Author:      alex
 * @CreateDate:  2019/5/27 11:06
 * @param
 * @return
*/
public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap maximumSwap=new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(98368));
    }
    private int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
