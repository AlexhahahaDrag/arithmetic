package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * @author:      alex
 * @createTime:  2020/8/25 20:28
 * @version:     1.0
 */
public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        int[] res = new int[nums.length];
        dfs(nums, 0, res, - 1);
        return result;
    }

    private void dfs(int[] nums, int index, int[] res, int size) {
        if (index == nums.length) {
            if (size >= 1) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= size; i++)
                    list.add(res[i]);
                result.add(list);
            }
            return;
        }
        if (size == -1 || nums[index] >= res[size]) {
            res[++size] = nums[index];
            dfs(nums, index + 1, res, size);
            size--;
        }
        if (size == -1 || nums[index] != res[size])
            dfs(nums, index + 1, res, size);
    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences1(int[] nums) {
        dfs1(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs1(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs1(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs1(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,1,1,1,1,1};
       int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        //int[] nums = {4,6,7,7};
        FindSubsequences findSubsequences = new FindSubsequences();
        List<List<Integer>> list1 = findSubsequences.findSubsequences1(nums);
        List<List<Integer>> list2 = findSubsequences.findSubsequences(nums);
        System.out.println(list1);
        System.out.println(list2);
    }
}
