/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int start=0;
        int end=A.length-1;
        while(start<end){
            while((A[start]&1)==0&&start<end){
                start++;
            }
            while(A[end]%2==1&&start<end){
                end--;
            }
            int num=A[end];
            A[end]=A[start];
            A[start]=num;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr1={4,1,2,6,3};
        int[] arr=sortArrayByParity(arr1);
        for (int a:
             arr) {
            System.out.println(a);
        }
    }
}
