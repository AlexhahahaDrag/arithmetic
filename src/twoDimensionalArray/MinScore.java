package twoDimensionalArray;

import java.util.*;

/**
 * description:
 * 2492. 两个城市间路径的最小分数
 * 中等
 * 10
 * 相关企业
 * 给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。
 * <p>
 * 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。
 * <p>
 * 城市 1 和城市 n 之间的所有路径的 最小 分数。
 * <p>
 * 注意：
 * <p>
 * 一条路径指的是两个城市之间的道路序列。
 * 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
 * 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * 输出：5
 * 解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
 * 不存在分数更小的路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * 输出：2
 * 解释：城市 1 到城市 4 分数最小的路径是：1 -> 2 -> 1 -> 3 -> 4 。这条路径的分数是 min(2,2,4,7) = 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * 不会有重复的边。
 * 城市 1 和城市 n 之间至少有一条路径。
 * author:       majf
 * createDate:   2022/12/6 18:31
 * version:      1.0.0
 */
public class MinScore {

    Map<Integer, List<int[]>> map;

    public int minScore(int n, int[][] roads) {
        map = new HashMap<>();
        for (int[] i : roads) {
            get(i[0], i);
            get(i[1], i);
        }
        boolean[] vi = new boolean[n + 1];
        int min = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(map.get(1));
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            min = Math.min(min, cur[2]);
            if (!vi[cur[0]] && map.get(cur[0]) != null) {
                queue.addAll(map.get(cur[0]));
            }
            if (!vi[cur[1]] && map.get(cur[1]) != null) {
                queue.addAll(map.get(cur[1]));
            }
            vi[cur[0]] = true;
            vi[cur[1]] = true;
        }
        return min;
    }

    private void get(int cur, int[] i) {
        List<int[]> res = map.get(cur);
        if (res == null) {
            res = new ArrayList<>();
            map.put(cur, res);
        }
        res.add(i);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        MinScore minScore = new MinScore();
        System.out.println(minScore.minScore(n, roads));
    }
}
