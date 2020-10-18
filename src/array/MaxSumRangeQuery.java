package array;

import java.util.Arrays;

/**
 *description:
 * 5505. 所有排列中的最大和 显示英文描述
 * 通过的用户数85
 * 尝试过的用户数128
 * 用户总通过次数85
 * 用户总提交次数165
 * 题目难度Medium
 * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
 *
 * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
 *
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * 输出：19
 * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * 总和为：8 + 3 = 11。
 * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
 * 输出：11
 * 解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
 * 输出：47
 * 解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] <= 105
 * 1 <= requests.length <= 105
 * requests[i].length == 2
 * 0 <= starti <= endi < n
 *author:       alex
 *createDate:   2020/9/19 22:45
 *version:      1.0.0
 */
public class MaxSumRangeQuery {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] map = new int[nums.length];
        for(int[] i : requests)
            for(int j = i[0]; j <= i[1]; j++)
                map[j]++;
        int[] li = new int[nums.length + 1];
        for (int i = 0; i < map.length; i++)
            li[map[i]]++;
        Arrays.sort(nums);
        int[] result = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            result[i + 1] = result[i] + nums[i];
        int cur = nums.length;
        int mod = 1000000007;
        long sum = 0;
        for(int i = li.length - 1; i >= 1; i--) {
            if (li[i] == 0)
                continue;
            sum += (long)(result[cur] - result[cur - li[i]]) * i;
            cur -= li[i];
        }
        return (int)sum % mod;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[][] request = {{1,3},{0,1}};
 /*       int[] nums = {4,5,1};
        int[][] request = {{0,1},{0,2},{1,2}};*/
        MaxSumRangeQuery maxSumRangeQuery = new MaxSumRangeQuery();
        System.out.println(maxSumRangeQuery.maxSumRangeQuery(nums, request));
    }
}
