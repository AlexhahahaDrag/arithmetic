package array;

import java.util.Arrays;

/**
 * @description:
 *
代码

测试用例
测试结果
测试结果

907. 子数组的最小值之和
中等
相关标签
相关企业
给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。

由于答案可能很大，因此 返回答案模 10^9 + 7 。



示例 1：

输入：arr = [3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
示例 2：

输入：arr = [11,81,94,43,3]
输出：444


提示：

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

 * @author:       majf
 * @createDate:   2023/11/27 10:53
 * @version:      1.0.0
 */
public class SumSubarrayMins {

    private Integer MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int res = 0;
        int[] min = new int[arr.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            res = (res + getSum(arr[i], min, i)) % MOD;
        }
        return res;
    }

    private int getSum(int cur, int[] min, int i) {
        int sum = 0;
        int index = -1;
        while(++index <= i) {
            int minVal = Math.min(min[index], cur);
            min[index] = minVal;
            sum = (sum + minVal) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        System.out.println(sumSubarrayMins.sumSubarrayMins(arr));
    }
}
