package array;

/**
 * @description:
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * @author:      alex
 * @createTime:  2021/6/3 17:34
 * @version:     1.0
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        if(nums == null ||  nums.length <= 1) {
            return 0;
        }
        int[] map = new int[nums.length];
        int size = 0;
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(pre == nums[i]) {
                map[size]++;
            } else {
                map[++size]++;
                pre = nums[i];
            }
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.min(map[i], map[i + 1]);
        }
        return max << 1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 0 , 0, 0, 1, 1, 0, 1, 1, 1, 0, 0 ,0};
//        int[] nums = {0,0,1,0,0,0,1,1};
        int[] nums = {0,1,1,0,1,1,1,0};
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(nums));
    }
}
