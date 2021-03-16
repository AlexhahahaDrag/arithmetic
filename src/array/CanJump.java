package array;

/**
 *description:
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *author:       alex
 *createDate:  2020/2/27 13:13
 *version:      1.0.0
*/
public class CanJump {

    public boolean canJump1(int[] nums) {
        int index = nums.length - 1;
        for (int i = index; i >= 0 ; i--) {
            if (i + nums[i] >= index) {
                index = i;
            }
        }

        return index == 0;
    }

    public boolean canJump(int[] nums) {
        boolean[] map = new boolean[nums.length];
        return dfs(nums, 0, map);
    }

    private boolean dfs(int[] nums, int index, boolean[] map) {
        if (index + nums[index] >= nums.length - 1) {
            return true;
        }
        for (int i = index; i <= index + nums[index]; i++) {
            if (map[i]) {
                continue;
            }
            map[i] = true;
            if (dfs(nums, i, map)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs1(int[] nums, int index, boolean[] map) {
        if (index + nums[index] >= nums.length - 1) {
            return true;
        }
        int start = index - nums[index] < 0 ? 0 : index - nums[index];
        int end = index + nums[index];
        for (int i = start; i <= end; i++) {
            if (map[i]) {
                continue;
            }
            map[i] = true;
            if (dfs(nums, i, map)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));
    }
}
