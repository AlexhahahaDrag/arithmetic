import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 * @Author:      alex
 * @CreateDate:  2019/2/13 16:06
 * @param
 * @return
*/
public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        int[] A={1,2,3,4};
        System.out.println(largestTimeFromDigits(A));
    }
    public static String largestTimeFromDigits(int[] A) {
        int time=-1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i!=j) {
                    for (int k = 0; k < 4; k++) {
                        if (i!=k&&j!=k){
                            int l=6-i-j-k;
                            int hour=A[i]*10+A[j];
                            int min=A[k]*10+A[l];
                            if (hour<24&&min<60){
                                time=Math.max(time,hour*60+min);
                            }
                        }
                    }
                }
            }
        }
        return time==-1?"":((time/60>10?time/60:("0"+time/60))+":"+(time%60>10?time%60:("0"+time%60)));
    }
}
