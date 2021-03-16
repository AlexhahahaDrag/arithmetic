/**
 * @Description: Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *
 *
 * Example 1:
 *
 * Input: [2,1]
 * Output: false
 * Example 2:
 *
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 *
 * Input: [0,3,2,1]
 * Output: true
 *
 *
 * Note:
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * @Author:      alex
 * @CreateDate:  2019/3/19 16:53
 * @param
 * @return
*/
public class ValidMountainArray {
    public static void main(String[] args) {
        int A[]={0,3,2,1};
        System.out.println(validMountainArray(A));
    }
    public static boolean validMountainArray(int[] A) {
        int len=A.length;
        if(len<3) {
            return false;
        }
        int positive=0;
        int negetive=0;
        for(int i=0;i<len-1;i++){
            if(A[i]<A[i+1]){
                if(negetive!=0) {
                    return false;
                } else {
                    positive++;
                }
            }else if(A[i]>A[i+1]){
                if(positive==0) {
                    return false;
                } else {
                    negetive++;
                }
            }else {
                return false;
            }
        }
        return positive>0&&negetive>0;
    }
}
