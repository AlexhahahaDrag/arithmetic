package twoDimensionalArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *description:
 * 2097. 合法重新排列数对
 * 给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。如果 pairs 的一个重新排列，满足对每一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法重新排列 。
 *
 * 请你返回 任意一个 pairs 的合法重新排列。
 *
 * 注意：数据保证至少存在一个 pairs 的合法重新排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pairs = [[5,1],[4,5],[11,9],[9,4]]
 * 输出：[[11,9],[9,4],[4,5],[5,1]]
 * 解释：
 * 输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
 * end0 = 9 == 9 = start1
 * end1 = 4 == 4 = start2
 * end2 = 5 == 5 = start3
 * 示例 2：
 *
 * 输入：pairs = [[1,3],[3,2],[2,1]]
 * 输出：[[1,3],[3,2],[2,1]]
 * 解释：
 * 输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
 * end0 = 3 == 3 = start1
 * end1 = 2 == 2 = start2
 * 重新排列后的数组 [[2,1],[1,3],[3,2]] 和 [[3,2],[2,1],[1,3]] 都是合法的。
 * 示例 3：
 *
 * 输入：pairs = [[1,2],[1,3],[2,1]]
 * 输出：[[1,2],[2,1],[1,3]]
 * 解释：
 * 输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
 * end0 = 2 == 2 = start1
 * end1 = 1 == 1 = start2
 *
 *
 * 提示：
 *
 * 1 <= pairs.length <= 105
 * pairs[i].length == 2
 * 0 <= starti, endi <= 109
 * starti != endi
 * pairs 中不存在一模一样的数对。
 * 至少 存在 一个合法的 pairs 重新排列。
 *author:       alex
 *createDate:   2021/12/8 22:57
 *version:      1.0.0
 */
public class ValidArrangement {

    private int[][] res;
    private int size;
    private Map<Integer, Stack<Integer>> map;
    public int[][] validArrangement(int[][] pairs) {
        res = new int[pairs.length][2];
        size = pairs.length - 1;
        map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        Stack<Integer> cur;
        for(int[] i : pairs) {
            count.put(i[0], count.getOrDefault(i[0], 0) + 1);
            count.put(i[1], count.getOrDefault(i[1], 0) - 1);
            if((cur = map.get(i[0])) == null) {
                cur = new Stack<>();
                map.put(i[0], cur);
            }
            cur.add(i[1]);
        }
        int start = 100000001;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                start = entry.getKey();
                break;
            }
        }
        dfs(start == 100000001 ? pairs[0][0] : start);
        return res;
    }

    private void dfs(int start) {
        Stack<Integer> stack = map.get(start);
        while(stack != null && stack.size() > 0) {
            int cur = stack.pop();
            dfs(cur);
            res[size--] = new int[]{start, cur};
        }
    }


    public static void main(String[] args) {
//        int[][] pairs = {{5,1}, {4,5}, {11,9}, {9,4}};
        int[][] pairs = {{1, 3}, {3, 2}, {2, 1}};
        ValidArrangement validArrangement = new ValidArrangement();
        int[][] res = validArrangement.validArrangement(pairs);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
