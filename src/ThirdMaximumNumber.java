/**
 * @Description: Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * @Author:      alex
 * @CreateDate:  2019/2/19 15:41
 * @param
 * @return
*/
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[]  nums={2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        long first=nums[0];
        long second=-(long)Math.pow(2,32)-1;
        long third=-(long)Math.pow(2,32)-1;
        for (int i = 0; i < nums.length; i++) {
            long index=nums[i];
            if (index>first){
                long temp=first;
                first=index;
                index=temp;
            }else if (index==first) {
                continue;
            }
            if (index>second){
                long temp=second;
                second=index;
                index=temp;
            }else if (index==second) {
                continue;
            }
            if (index>third){
                long temp=third;
                third=index;
                index=temp;
            }
        }
        return third<Integer.MIN_VALUE?(int)first:(int)third;
    }
}
