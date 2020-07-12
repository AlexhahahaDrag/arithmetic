package array;

/**
 *description:
 * 5460. 好数对的数目
 * 难度
 * 简单
 *
 * 0
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *author:       alex
 *createDate:   2020/7/12 21:01
 *version:      1.0.0
 */
public class MumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        for (int i : nums)
            map[i]++;
        int res = 0;
        for (int i : map)
            if (i > 1)
                res += i * (i - 1) >> 1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        MumIdenticalPairs mumIdenticalPairs = new MumIdenticalPairs();
        System.out.println(mumIdenticalPairs.numIdenticalPairs(nums));
    }
}
