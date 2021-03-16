package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * Author:      alex
 * CreateDate:  2020/6/11 19:54
 * Version:     1.0
 *
*/
public class TopKFrequent {

    public int[] topKFrequent1(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (list[count] == null) {
                list[count] = new ArrayList<>();
            }
            list[count].add(entry.getKey());
        }
        int index = 0;
        for(int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                for(int nu : list[i]) {
                    if (index < k) {
                        res[index++] = nu;
                    } else {
                        break;
                    }
                }
            }
            if (index >= k) {
                break;
            }

        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list[entry.getValue()] == null) {
                list[entry.getValue()] = new ArrayList<>();
            }
            list[entry.getValue()].add(entry.getKey());
         }
        int[] res = new int[k];
        int index = 0;
        for(int l = list.length - 1; l >= 0 && index < k; l--) {
            for(int i = 0; list[l] != null && i < list[l].size() && index < k; i++) {
                res[index++] = list[l].get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] res = topKFrequent.topKFrequent(nums, k);
        for(int i : res) {
            System.out.print(i + "  ");
        }
        System.out.println("==============================================");
        int[] res1 = topKFrequent.topKFrequent(nums, k);
        for(int i : res1) {
            System.out.print(i + "  ");
        }
    }
}
