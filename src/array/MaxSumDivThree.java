package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/11/18 9:07
 * @Version:    1.0
 *
*/
public class MaxSumDivThree {

    public static void main(String[] args) {
        MaxSumDivThree maxSumDivThree = new MaxSumDivThree();
        int[] nums = {3,6,5,1,8};
        System.out.println(maxSumDivThree.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 1)
                one.add(nums[i]);
            else if (nums[i] % 3 == 2)
                two.add(nums[i]);
            sum += nums[i];
        }
        Collections.sort(one);
        Collections.sort(two);
        int ind = sum % 3;
        if (ind == 0)
            return sum;
        int on = Integer.MAX_VALUE;
        int to = Integer.MAX_VALUE;
        if (ind == 1) {
            if (one.size() > 0)
                on = one.get(0);
            if (two.size() > 1)
                to = two.get(0) + two.get(1);
            return sum - (on > to ? to : on);
        } else {
            if (one.size() > 1)
                on = one.get(0) + one.get(1);
            if (two.size() > 0)
                to = two.get(0);
            return sum - (on > to ? to : on);
        }
    }
}
