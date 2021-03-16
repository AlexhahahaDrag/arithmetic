package array;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 * 523. 连续的子数组和
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1:
 *
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 *
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * 说明:
 *
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 *author:       alex
 *createDate:   2020/5/28 20:46
 *version:      1.0.0
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] sums = new int[nums.length + 1];
        int sum = 0;
        int index = 0;
        for (int i : nums) {
            sum += i;
            sums[++index] = sum;
        }
        for (int i = 0; i < sums.length - 2; i++) {
            for (int j = i + 2; j < sums.length; j++) {
                if (sums[j] - sums[i] == k || (k != 0 && (sums[j] - sums[i]) % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        int k = 0;
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        System.out.println(checkSubarraySum.checkSubarraySum(nums, k));
    }
}
