package array;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 2225. 找出输掉零场或一场比赛的玩家
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * <p>
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * <p>
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * 示例 2：
 * <p>
 * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * 输出：[[1,2,5,6],[]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * 所有 matches[i] 互不相同
 * author:       majf
 * createDate:   2024/5/22 9:17
 * version:      1.0.0
 */
public class FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] wins = new int[100001];
        int[] losses = new int[100001];
        for (int[] match : matches) {
            wins[match[0]]++;
            losses[match[1]]++;
        }
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (wins[i] > 0 && losses[i] == 0) {
                        first.add(i);
            }
            if (losses[i] ==1) {
                second.add(i);
            }
        }
        answer.add(first);
        answer.add(second);
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(new FindWinners().findWinners(arr));
    }
}
