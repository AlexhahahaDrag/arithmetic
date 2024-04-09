package array;

/**
 * description:
 * 2529. 正整数和负整数的最大计数
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums 按 非递减顺序 排列。
 * author:       majf
 * createDate:   2024/4/9 10:31
 * version:      1.0.0
 */
public class MaximumCount {

    public int maximumCount(int[] nums) {
        int len = nums.length;
        int negative = binaryNegative(nums);
        int pos = binaryPositive(nums);
        return Math.max(negative, len - pos);
    }

    private int binaryPositive(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int binaryNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int maximumCount1(int[] nums) {
        int nega = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nega++;
            } else if (nums[i] == 0) {
                if (nega >= nums.length + 1 >> 1) {
                    return nega;
                }
            } else {
                return Math.max(nums.length - i, nega);
            }
        }
        return nega;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {-1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {-2, -1, -1, 1, 2, 3}, // 3
                {-3, 0, 0, 1, 2}, // 3
                {-3, -2, -1, 0, 0, 1, 2}, // 3
                {-3, -2, -1, 0, 0, 1, 2, 3, 4} // 4
        };
        MaximumCount maximumCount = new MaximumCount();
        for (int[] num : nums) {
            System.out.println(maximumCount.maximumCount(num));
            System.out.println(maximumCount.maximumCount1(num));
            System.out.println("==================");
        }
    }
}
