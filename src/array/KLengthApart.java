package array;

/**
 * Description:
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 *
 *
 *
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * 示例 3：
 *
 * 输入：nums = [1,1,1,1,1], k = 0
 * 输出：true
 * 示例 4：
 *
 * 输入：nums = [0,1,0,1], k = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 * Author:      alex
 * CreateDate:  2020/6/1 12:47
 * Version:     1.0
 *
*/
public class KLengthApart {

    public boolean kLengthApart1(int[] nums, int k) {
        int len = k;
        for(int i : nums) {
            if (i == 1) {
                if (len >= k) {
                    len = 0;
                } else {
                    return false;
                }
            } else {
                len++;
            }
        }
        return true;
    }

    public boolean kLengthApart2(int[] nums, int k) {
        if(k == 0) {
            return true;
        }
        int pre = -k - 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - pre - 1 < k) {
                    return false;
                }
                pre = i;
            }
        }
        return true;
    }

    public boolean kLengthApart(int[] nums, int k) {
        if(k == 0) {
            return true;
        }
        int i1 = indexOfOne(nums, 0);
        int i2 = indexOfOne(nums, i1 + 1);
        while (i2 > 0) {
            // System.out.println(i1 + " " + i2);
            if(i2 - i1 - 1 < k) {
                return false;
            }
            i1 = i2;
            i2 = indexOfOne(nums, i2 + 1);
        }
        return true;
    }

    // 下一个 1 的位置, 包括 nums[from]
    // -1 如果不存在的话
    private int indexOfOne(int[] nums, int from) {
        for (int i = from; i < nums.length; i++) {
            if(nums[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k = 2;
        KLengthApart kLengthApart = new KLengthApart();
        System.out.println(kLengthApart.kLengthApart(nums, k));
    }
}
