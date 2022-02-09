package array;

/**
 *description:
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 *
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 *
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *author:       alex
 *createDate:   2022/2/9 17:50
 *version:      1.0.0
 */
public class CountKDifference {

    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        for(int i : nums) {
            map[i]++;
        }
        int res = 0;
        for (int i = 0; i + k < map.length; i++) {
            res += map[i + k] * map[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int nums[] = {3,2,1,5,4};
//        int k = 2;//3
        int nums[] = {1,2,2,1};
        int k = 1;//3
        CountKDifference countKDifference = new CountKDifference();
        System.out.println(countKDifference.countKDifference(nums, k));
    }
}
