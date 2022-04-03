package twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 5235. 找出输掉零场或一场比赛的玩家
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 *
 * 示例 1：
 *
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * 示例 2：
 *
 * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * 输出：[[1,2,5,6],[]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 *
 *
 * 提示：
 *
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * 所有 matches[i] 互不相同
 *author:       alex
 *createDate:   2022/4/3 18:00
 *version:      1.0.0
 */
public class FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] win = new int[100001];
        int[] lose = new int[100001];
        for(int[] match : matches) {
            win[match[0]]++;
            lose[match[1]]++;
        }
        List<Integer> winl = new ArrayList<>();
        List<Integer> losel = new ArrayList<>();
        for(int i = 0; i < 100001; i++) {
            if(win[i] > 0 && lose[i] == 0) {
                winl.add(i);
            }
        }
        for(int j = 0; j < 100001; j++) {
            if(lose[j] == 1) {
                losel.add(j);
            }
        }
        List<List<Integer>> res = new ArrayList<>() ;
        res.add(winl);
        res.add(losel);
        return res;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        FindWinners findWinners = new FindWinners();
        System.out.println(findWinners.findWinners(matches));
    }
}
