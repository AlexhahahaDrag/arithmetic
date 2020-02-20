package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *description:
 * 18. 四数之和
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/13 20:53
 *version:      1.0.0      
*/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(target - nums[i] - nums[j], list);
            }
        }

        for (int k = 0; k < nums.length; k++) {
            for (int l = k + 1; l < nums.length; l++) {
                if (map.containsValue(nums[k] + nums[l])) {
                    list = map.get(nums[k] + nums[l]);
                    if (!list.contains(k) && !list.contains(l)) {
                        List<Integer> res = new ArrayList<>();
                        int index = 0;
                        int len = list.size();
                        res.add(nums[k]);
                        res.add(nums[l]);
                        while(index < len) {
                            res.add(nums[list.get(index++)]);
                        }
                        result.add(res);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(arr, 0));
    }
}
