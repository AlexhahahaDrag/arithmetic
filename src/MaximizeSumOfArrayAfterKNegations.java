import java.util.Arrays;

/**
 * @Description: Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 *
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 *
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * @Author:      alex
 * @CreateDate:  2019/5/16 17:42
 * @param
 * @return
*/
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        int[] A = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(A,2));
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        Arrays.sort(A);
        int pre=A[0];
        for(int i=0;i<A.length&&K>0;i++,K--){
            if(A[i]<0){
                A[i]=-A[i];
                pre=A[i];
            }else if(A[i]==0) {
                break;
            } else {
                if((K&1)==1){
                    if(A[i]>pre) {
                        A[i-1]=-A[i-1];
                    } else {
                        A[i]=-A[i];
                    }
                }
                break;
            }
        }
        for(int a:A) {
            sum+=a;
        }
        return sum;
    }
}
