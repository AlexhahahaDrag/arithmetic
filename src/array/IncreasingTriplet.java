package array;

import java.util.Arrays;

/**
 *description:
 * 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 * 通过次数14,949提交次数40,088
 *author:       alex
 *createDate:  2020/3/14 19:14
 *version:      1.0.0
*/
public class IncreasingTriplet {

    public boolean increasingTriplet1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0)
                i = -(i + 1);
            dp[i] = num;
            if (i == len) {
                len++;
                if (len >= 3)
                    return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet3(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int num : nums) {
            if (min >= num)
                min = num;
            else if (num > min && num <= max)
                max = num;
            else
                return true;
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int min = nums[0];
        int max = Integer.MAX_VALUE;
        for(int num : nums) {
            if (min >= num)
                min = num;
            else if (num > max)
                return true;
            else
                max = num;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, -2, -3};
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(arr));
    }
}
