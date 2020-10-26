package array;

import java.util.Arrays;

/**
 *description:
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *author:       alex
 *createDate:  2020/3/3 16:42
 *version:      1.0.0      
*/
public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] map = new int[101];
        for (int i = 0; i < nums.length; i++)
            map[nums[i]]++;
        int pre = 0;
        int cur;
        for (int i = 1; i < map.length; i++) {
            cur = map[i];
            map[i] = map[i - 1] + pre;
            pre = cur;
        }
        map[0] = 0;
        for (int i = 0; i < nums.length; i++)
            nums[i] = map[nums[i]];
        return nums;
    }

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] map = Arrays.copyOf(nums, nums.length);
        Arrays.sort(map);
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            for(int j =0; j < nums.length; j++) {
                if(map[j] == nums[i]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {};
        SmallerNumbersThanCurrent smallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
        int[] res = smallerNumbersThanCurrent.smallerNumbersThanCurrent(arr);
        for (int i: res)
            System.out.print(i + "   ");
    }
}
