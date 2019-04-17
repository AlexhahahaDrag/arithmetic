/**
 * @Description: An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 *
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * @Author:      alex
 * @CreateDate:  2019/2/25 17:17
 * @param
 * @return
*/
public class MonotonicArray {
    public static void main(String[] args) {
        int[] A={5,3,2,4,1};
        System.out.println(isMonotonic(A));
    }
    public static boolean isMonotonic(int[] A) {
        int x = 0;
        if (A[0] > A[A.length -1])
            x=1;
        if (x == 0) {
            for (int i = 0; i < A.length - 1; i++)
                if (A[i] > A[i + 1])
                    return false;
        }else if (x==1)
            for (int j = 0; j<A.length-1; j++)
                if (A[j] < A[j+1])
                    return false;
        return true;
    }
    public static boolean isMonotonic1(int[] A) {
        int index=0;
        boolean flagDaYu=true;
        boolean flagXiaoYu=true;
        while(index<A.length-1){
            if(flagXiaoYu&&A[index]<A[index+1])
                flagDaYu=false;
            else if(flagXiaoYu&&A[index]>A[index+1])
                flagXiaoYu=false;
            if(flagDaYu&&A[index]>A[index+1])
                flagXiaoYu=false;
            else if(flagDaYu&&A[index]<A[index+1])
                flagDaYu=false;
            index++;
        }
        return flagDaYu||flagXiaoYu;
    }
}
