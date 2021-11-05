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


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int len = 0;
        for(int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = - (i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    private int m = 1;
    private int[] dp;
    public int lengthOfLIS2(int[] nums) {
        dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            find(nums, i);
        }
        return m;
    }

    private void find(int[] nums, int i) {
        int max = 0;
        for (int j = i; j >= 0; j--) {
            if (max > j) {
                break;
            }
            if (nums[i] > nums[j]) {
                max = Math.max(max, dp[j]);
            }
        }
        dp[i] = max + 1;
        m = Math.max(max + 1, m);
    }

    public static void main(String[] args) {
//        int[] arr = {10,9,2,5,3,7,2, 3, 5, 6, 7,101,18};
        int[] arr = {10,9,2,5,3,7,101,18};
//        int[] arr = {0,1,0,3,2,3};
//        int[] arr = {1};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(arr));
        System.out.println(lengthOfLIS.lengthOfLIS1(arr));
    }
}
