package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @author:      alex
 * @createTime:  2020/9/11 9:15
 * @version:     1.0
 */
public class CombinationSum3 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        int[] map = new int[k];
        combination(map, 0, 1, n);
        return res;
    }

    private void combination(int[] map, int size, int start, int n) {
        if (map.length == size){
            if (n == 0) {
                List<Integer> li = new ArrayList<>();
                for(int i : map)
                    li.add(i);
                res.add(li);
            }
            return;
        }
        for (int i = start; i <= 9 && n >= i; i++) {
            map[size++] = i;
            combination(map, size, i + 1, n - i);
            size--;
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int n = 9;
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(k, n));
    }
}
