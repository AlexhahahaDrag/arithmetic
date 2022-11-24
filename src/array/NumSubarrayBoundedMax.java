package array;


/**
 * description:
 * 795. 区间子数组个数
 * 中等
 * 248
 * 相关企业
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= left <= right <= 109
 * author:       majf
 * createDate:   2022/11/24 11:10
 * version:      1.0.0
 */
public class NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int li = -1;
        int lr = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                li = i;
            } else if (nums[i] > right) {
                li = -1;
                lr = i;
            }
            if (li != -1) {
                res += li - lr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 5, 6};
        int left = 2;
        int right = 8;
        NumSubarrayBoundedMax numSubarrayBoundedMax = new NumSubarrayBoundedMax();
        System.out.println(numSubarrayBoundedMax.numSubarrayBoundedMax(nums, left, right));
    }
}
