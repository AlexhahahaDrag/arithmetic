package array;

/**
 * @description:
 * 456. 132模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 *
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 * @author:      alex
 * @createTime:  2021/3/24 12:53
 * @version:     1.0
 */
public class Find132pattern {

    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        int[][] map = new int[(nums.length + 1 >> 1)][2];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = Integer.MAX_VALUE;
            map[i][1] = Integer.MIN_VALUE;
        }
        int size = 0;
        int in = 0;
        for(int i : nums) {
            for(int j = 0; j <= size; j++) {
                if (map[j][0] < i && map[j][1] > i) {
                    return true;
                }
            }
            if (in == 0) {
                if (map[size][0] >= i) {
                    map[size][0] = i;
                } else {
                    map[size][1] = i;
                    in = 1;
                }
            } else if (in == 1) {
                if (map[size][1] <= i) {
                    map[size][1] = i;
                } else {

                    if (i < map[size][0]) {
                        map[++size][0] = i;
                    }
                    in = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        Find132pattern find132pattern = new Find132pattern();
        System.out.println(find132pattern.find132pattern(nums));
    }
}
