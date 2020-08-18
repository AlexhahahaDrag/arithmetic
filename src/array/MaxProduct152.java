package array;

/**
 * Description:
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * Author:      alex
 * CreateDate:  2020/6/4 12:33
 * Version:     1.0
 *
*/
public class MaxProduct152 {

    public int maxProduct(int[] nums) {
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        mins[0] = nums[0];
        maxs[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(nums[i], Math.min(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]));
            maxs[i] = Math.max(nums[i], Math.max(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]));
            res = Math.max(res, Math.max(mins[i], maxs[i]));
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 1;
        for(int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            res = Math.max(res, sum);
            if (sum == 0)
                sum = 1;
        }
        sum = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum *= nums[i];
            res = Math.max(res, sum);
            if (sum == 0)
                sum = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        MaxProduct152 maxProduct152 = new MaxProduct152();
        System.out.println(maxProduct152.maxProduct1(nums));
    }
}
