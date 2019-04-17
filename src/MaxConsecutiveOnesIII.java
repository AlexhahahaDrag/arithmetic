/**
 * @Description: Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 *
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1
 * @Author:      alex
 * @CreateDate:  2019/3/4 10:22
 * @param
 * @return
*/
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int []A = {0};
        System.out.println(longestOnes(A,35));
    }
    public static int longestOnes(int[] A, int K) {
        int[] index=new int[A.length];
        int size=0;
        int start=0;
        if(A[0]==0)
            start=1;
        index[0]++;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1])
                index[size]++;
            else
                index[++size]++;
        }
        int sum=K;
        while(start<size){
            sum=Math.max(sum,getSum(start,K,index,size));
            start+=2;
        }
        return sum>A.length?A.length:sum;
    }
    public static int getSum(int start,int K,int[] index,int size){
        int sum=K;
        sum+=index[start++];
        int begin=start;
        while(start<=size&&K>=0){
            if((begin&1)==(start&1))
                K-=index[start];
            else
                sum+=index[start];
            start++;
        }
        return sum;
    }
}
