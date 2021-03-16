package array;

import java.util.Arrays;

/**
 *description:
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *author:       alex
 *createDate:  2020/3/14 18:39
 *version:      1.0.0      
*/
public class LengthOfLIS {

    private int max = 0;
    public int lengthOfLIS(int[] nums) {
        find(nums, 0, Integer.MIN_VALUE, 0);
        return max;
    }

    private void find(int[] nums, int start, int cur, int len) {
        max = Math.max(max, len);
        if (max > nums.length - start + len) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (cur < nums[i]) {
                find(nums, i + 1, nums[i], len + 1);
            }
        }
    }

    public int lengthOfLIS1(int[] nums) {
        int len = 0;
        int[] dp= new int[nums.length];
        for (int num:nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i<0) {
                i= -(i+1);
            }
            dp[i] = num;
            if (i==len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,2, 3, 5, 6, 7,101,18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS1(arr));
    }
}
