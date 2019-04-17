/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class CountOfRangeSum {
    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        System.out.println(countRangeSun(nums,-564,3864));
    }
    public static int countRangeSun(int[] nums,int lower,int upper){
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            long sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum>=lower&&sum<=upper)
                    result++;
            }
        }
        return result;
    }

}
