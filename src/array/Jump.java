package array;

/**
 *description:
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *author:       alex
 *createDate:  2020/2/27 13:28
 *version:      1.0.0
*/
public class Jump {

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        return dfs(nums,0,0);
    }

    private int dfs(int[] nums, int index, int count) {
        if (index >= nums.length - 1)
            return count;
        int res = finMaxIndex(nums, index);
        if (res == index)
            return -1;
        return dfs(nums, res, count + 1);
    }

    private int finMaxIndex(int[] nums, int index) {
        if (index + nums[index] >= nums.length - 1)
            return nums.length - 1;
        int end = index + nums[index];
        for (int i = index + 1; i <= end; i++) {
            if (index + nums[index] < i + nums[i])
                index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        //int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        //int[] nums = {1,2,1,1,1};
        //int[] nums = {2};
        int[] nums = { 2,3,1,1,4};
        Jump jump = new Jump();
        System.out.println(jump.jump(nums));
    }
}
