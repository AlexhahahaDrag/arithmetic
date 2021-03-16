package array;

import java.util.*;

/**
 * @description:
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @author:      alex
 * @createTime:  2020/9/10 9:25
 * @version:     1.0
 */
public class CombinationSum2 {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        int[] map = new int[target % candidates[0] == 0 ? target / candidates[0] : target / candidates[0] + 1];
        combination(candidates, target, 0, map, 0);
        return res;
    }

    private void combination(int[] candidates, int target, int start, int[] map, int size) {
        if(target == 0) {
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list1.add(map[i]);
            }
            res.add(list1);
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            map[size++] = candidates[i];
            combination(candidates, target - candidates[i], i + 1, map, size);
            size--;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(candidates, target));
    }
}
