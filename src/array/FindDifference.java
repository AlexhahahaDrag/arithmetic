package array;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 5268. 找出两数组的不同
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 *
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 * 解释：
 * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
 * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
 * 示例 2：
 *
 * 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * 输出：[[3],[]]
 * 解释：
 * 对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
 * nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 *author:       alex
 *createDate:   2022/3/27 14:55
 *version:      1.0.0
 */
public class FindDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] map = new int[2001];
        for(int i : nums1) {
            map[i + 1000] = 1;
        }
        for(int j : nums2) {
            if(map[j + 1000] == 1) {
                map[j + 1000] = 2;
            } else if(map[j + 1000] == 2) {
                continue;
            } else {
                map[j + 1000] = -1;
            }
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 1) {
                list1.add(i - 1000);
            } else if(map[i] == -1){
                list2.add(i - 1000);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        FindDifference findDifference = new FindDifference();
        System.out.println(findDifference.findDifference(nums1, nums2));
    }
}
