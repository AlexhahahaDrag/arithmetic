package list;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 2824. 统计和小于目标的下标对数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,1,2,3,1], target = 2
 * 输出：3
 * 解释：总共有 3 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
 * - (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
 * 注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target 。
 * 示例 2：
 * <p>
 * 输入：nums = [-6,2,5,-2,-7,-1,3], target = -2
 * 输出：10
 * 解释：总共有 10 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = -4 < target
 * - (0, 3) ，0 < 3 且 nums[0] + nums[3] = -8 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = -13 < target
 * - (0, 5) ，0 < 5 且 nums[0] + nums[5] = -7 < target
 * - (0, 6) ，0 < 6 且 nums[0] + nums[6] = -3 < target
 * - (1, 4) ，1 < 4 且 nums[1] + nums[4] = -5 < target
 * - (3, 4) ，3 < 4 且 nums[3] + nums[4] = -9 < target
 * - (3, 5) ，3 < 5 且 nums[3] + nums[5] = -3 < target
 * - (4, 5) ，4 < 5 且 nums[4] + nums[5] = -8 < target
 * - (4, 6) ，4 < 6 且 nums[4] + nums[6] = -4 < target
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == n <= 50
 * -50 <= nums[i], target <= 50
 * @author: majf
 * @createDate: 2023/11/24 13:40
 * @version: 1.0.0
 */
public class CountPairs {

    public int countPairs(List<Integer> nums, int target) {
        int[] map = new int[101];
        for (int i : nums) {
            map[i + 50]++;
        }
        int res = 0;
        for (int i = 0; i < 101; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] >= 2 && (i + i - 100) < target) {
                res += map[i] * (map[i] - 1) / 2;
            }
            for (int j = i + 1; j < 101; j++) {
                if (map[j] == 0) {
                    continue;
                }
                if (i + j - 100 >= target) {
                    break;
                }
                res += map[i] * map[j];
            }
        }
        return res;
    }

    public int countPairs1(List<Integer> nums, int target) {
        int res = 0;
        Integer[] num = nums.toArray(new Integer[0]);
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] < target) {
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-6, 2, 5, -2, -7, -1, 3, -1);
        int target = -2;
        CountPairs countPairs = new CountPairs();
        System.out.println(countPairs.countPairs(nums, target));
    }
}
