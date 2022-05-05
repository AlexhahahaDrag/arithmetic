package array;

/**
 *description:
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *author:       alex
 *createDate:   2022/5/5 20:48
 *version:      1.0.0
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int sum = 1;
        int index = 0;
        int i = 0;
        for(; i < nums.length; i++) {
            if(nums[i] >= k) {
                res += (i - index) * (i - index + 1) / 2;
                index = i + 1;
                sum = 1;
                continue;
            }
            sum *= nums[i];
            while (sum >= k && index < i) {
                res += i - index;
                sum /= nums[index++];
            }
        }
        if(index < i && sum < k) {
            res += (i - index) * (i - index + 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};//9
        int k = 20;

//        int[] nums = {10,5,2,6};//8
//        int k = 100;
//        int[] nums = {3, 7, 8, 10, 1, 2, 4, 1};//18
//        int k = 59;
//        int[] nums = {10,5,2,6, 103, 2, 7, 8, 10};//15
//        int k = 100;

        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(nums, k));
    }
}
