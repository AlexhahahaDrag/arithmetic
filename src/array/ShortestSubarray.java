package array;

import java.util.ArrayDeque;

/**
 * @description:
 * 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 *
 * 子数组 是数组中 连续 的一部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 * @author: alex
 * @createDate: 2022/10/26 6:56
 * @version: 1.0.0
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] sum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res = len + 1;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len + 1; i++) {
            long cur = sum[i];
            while (!deque.isEmpty() && cur - sum[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] >= cur) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res == len + 1 ? - 1 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, - 1, 2};
        int k = 4;
        ShortestSubarray shortestSubarray = new ShortestSubarray();
        System.out.println(shortestSubarray.shortestSubarray(nums, k));
    }
}
