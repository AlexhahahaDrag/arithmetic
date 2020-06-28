package array;

/**
 * Description:
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * Author:      alex
 * CreateDate:  2020/6/28 12:20
 * Version:     1.0
 *
*/
public class MinSubArrayLen {

    public int minSubArrayLen1(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0)
            return 0;
        int[] map = new int[nums.length];
        if (nums[0] >= s)
            return 1;
        map[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            map[i] = map[i - 1] + nums[i];
            if (map[i] >= s)
                res = Math.min(res, i + 1);
        }
        int len = 0;
        outloop: while(len++ < nums.length) {
            for (int i = 0; i < nums.length - len; i++) {
                if (map[i + len] - map[i] >= s) {
                    res = Math.min(res, len);
                    break outloop;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        int total = nums[0];
        int start = 0;
        int end = 0;
        while(start <= end) {
            if (total >= s) {
                if (res > end - start)
                    res = end - start;
                total -= nums[start];
                start++;
            } else {
                if (end != nums.length - 1) {
                    end++;
                    total += nums[end];
                } else {
                    //为了结束循环
                    total -= nums[start];
                    start++;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res + 1;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(s, nums));
    }
}


