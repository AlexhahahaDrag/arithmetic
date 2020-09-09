package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @author:      alex
 * @createTime:  2020/9/9 11:40
 * @version:     1.0
 */
public class CombinationSum {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int min = Integer.MAX_VALUE;
        for(int i : candidates)
            if (min > i)
                min = i;
        res = new ArrayList<>();
        int[] map = new int[target % min == 0 ? target / min : target / min + 1];
        combination(candidates, target, 0, map, 0);
        return res;
    }

    private void combination(int[] candidates, int target, int start, int[] map, int size) {
        if (0 == target) {
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++)
                list.add(map[i]);
            res.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            map[size++] = candidates[i];
            combination(candidates, target - candidates[i], i, map, size);
            size--;
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        zuhe(candidates,target,0,list,res);
        return res;
    }
    public void zuhe(int[] candidates, int target,int index,List<Integer> list,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target<candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            zuhe(candidates,target-candidates[i],i,list,res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5, 5};
        int target = 8;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum1(candidates, target));
    }
}
