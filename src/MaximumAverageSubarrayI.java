/**
 * @Description: Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * @Author:      alex
 * @CreateDate:  2019/5/13 15:45
 * @param
 * @return
*/
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums={1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int j=k;j<nums.length;j++){
            sum+=nums[j]-nums[j-k];
            res=Math.max(sum,res);
        }
        return res/k;
    }
}
