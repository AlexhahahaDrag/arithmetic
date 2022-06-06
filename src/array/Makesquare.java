package array;

import java.util.Arrays;

/**
 *description:
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 *
 * 提示:
 *
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 *author:       alex
 *createDate:   2022/6/1 13:40
 *version:      1.0.0
 */
public class Makesquare {

    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        for(int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 > 0) {
            return false;
        }
        int len = (int)(sum / 4);
        int[] edges = new int[4];
        Arrays.sort(matchsticks);
        return dfs(matchsticks.length - 1, len, matchsticks, edges);
    }

    private boolean dfs(int index, int len, int[] m, int[] edges) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += m[index];
            if (len >= edges[i] && dfs(index - 1, len, m, edges)) {
                return true;
            }
            edges[i] -= m[index];
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] matchsticks = {1, 1, 2,  2, 2};//true
//        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};//true
        int[] matchsticks =  {10,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Makesquare makesquare = new Makesquare();
        System.out.println(makesquare.makesquare(matchsticks));
    }
}
