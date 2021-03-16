package array;

import java.util.*;

/**
 * @description:
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @author:      alex
 * @createTime:  2020/9/18 11:13
 * @version:     1.0
 */
public class PermuteUnique {

    List<List<Integer>> res1;
    public List<List<Integer>> permuteUnique1(int[] nums) {
        res1 = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res1;
        }
        Arrays.sort(nums);
        add(nums);
        dfs(nums, nums.length - 1);
        System.out.println(res1.size());
        return res1;
    }

    private void dfs(int[] nums, int start) {
        if (start <= 0) {
            return;
        }
        for (int i = start; i >= 0; i--) {
            if (nums[i] < nums[start]) {
                swap(nums, i, start);
                Arrays.sort(nums, i + 1, nums.length);
                add(nums);
                dfs(nums, nums.length - 1);
                break;
            }
        }
        dfs(nums, start - 1);
    }

    private void add(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int j : nums) {
            list.add(j);
        }
        res1.add(list);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> deque = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs1(nums, 0, deque, visited);
        return res;
    }

    private void dfs1(int[] nums, int depth, List<Integer> deque, boolean[] visited) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(deque));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            deque.add(nums[i]);
            dfs1(nums, depth + 1, deque, visited);
            visited[i] = false;
            deque.remove(deque.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,-1,2,1,-1,2,1};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique1(nums));
        System.out.println(permuteUnique.permuteUnique(nums));
    }
}
