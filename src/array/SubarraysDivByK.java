package array;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *author:       alex
 *createDate:  2020/2/28 9:31
 *version:      1.0.0
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        //0第一个就可以被整除
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i : A) {
            sum += i;
            //去除当除数为负数的时候去mod为负值的情况
            int mod = (sum % K + K) % K;
            int cur = map.getOrDefault(mod, 0);
            ans += cur;
            map.put(mod, cur + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1};
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        System.out.println(subarraysDivByK.subarraysDivByK(nums, 5));
    }
}
