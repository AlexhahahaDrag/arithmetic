package array;

import java.util.*;

/**
 * @description:
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 * @author:      alex
 * @createTime:  2021/6/7 11:30
 * @version:     1.0
 */
public class FindTargetSumWays {

    public int findTargetSumWays1(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(target > sum || -target > sum) {
            return 0;
        }
        int len = Math.min(2001, (sum << 1) + 1);
        int[] res = new int[len];
        int[] map;
        for (int i = 0; i < nums.length; i++) {
            map = new int[len];
            if(i == 0) {
                map[nums[i] + sum] = 1;
                map[-nums[i] + sum] += 1;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if(res[j] != 0) {
                        map[j + nums[i]] += res[j];
                        map[j - nums[i]] += res[j];
                    }
                }
            }
            res = Arrays.copyOf(map, map.length);
        }
        return res[target + sum];
    }


    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(target > sum || -target > sum) {
            return 0;
        }
        int len = Math.min(2001, (sum << 1) + 1);
        int[] res = new int[len];
        int[] map;
        for (int i = 0; i < nums.length; i++) {
            map = new int[len];
            if(i == 0) {
                map[nums[i] + sum] = 1;
                map[-nums[i] + sum] += 1;
            } else {
                for (int j = 0; j < map.length; j++) {
                    if(res[j] != 0) {
                        map[j + nums[i]] += res[j];
                        map[j - nums[i]] += res[j];
                    }
                }
            }
            res = Arrays.copyOf(map, map.length);
        }
        return res[target + sum];
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1};
//        int target = 3;
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(nums, target));
    }
}

