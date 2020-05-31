package array;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 560. 和为K的子数组
 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

 示例 1 :

 输入:nums = [1,1,1], k = 2
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 说明 :

 数组的长度为 [1, 20,000]。
 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *author:       alex
 *createDate:  2020/2/28 9:31
 *version:      1.0.0
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        sum = 0;
        for(int i : nums) {
            sum += i;
            if (sum == k)
                ans++;
            if (sum >= min && sum <= max) {
                if (map.containsKey(sum - k))
                    ans += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, 2));
    }
}
