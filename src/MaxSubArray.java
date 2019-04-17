/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/1/11 11:22
 * @Version:    1.0
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums={-3,-2,0,-1};
        System.out.println(getMaxSub(nums));
    }
    public static int getMaxSub(int[] nums){
        int maxSub=nums[0];
        int thisSub=0;
        for (int i = 0; i < nums.length; i++) {
            thisSub+=nums[i];
            if (thisSub>maxSub)
                maxSub=thisSub;
            if (thisSub<0)
                thisSub=0;
        }
        return maxSub;
    }
}
