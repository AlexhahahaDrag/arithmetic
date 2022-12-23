package twoDimensionalArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 * 2493. 将节点分成尽可能多的组
 * 困难
 * 11
 * 相关企业
 * 给你一个正整数 n ，表示一个 无向 图中的节点数目，节点编号从 1 到 n 。
 * <p>
 * 同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 双向 边。注意给定的图可能是不连通的。
 * <p>
 * 请你将图划分为 m 个组（编号从 1 开始），满足以下要求：
 * <p>
 * 图中每个节点都只属于一个组。
 * 图中每条边连接的两个点 [ai, bi] ，如果 ai 属于编号为 x 的组，bi 属于编号为 y 的组，那么 |y - x| = 1 。
 * 请你返回最多可以将节点分为多少个组（也就是最大的 m ）。如果没办法在给定条件下分组，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
 * 输出：4
 * 解释：如上图所示，
 * - 节点 5 在第一个组。
 * - 节点 1 在第二个组。
 * - 节点 2 和节点 4 在第三个组。
 * - 节点 3 和节点 6 在第四个组。
 * 所有边都满足题目要求。
 * 如果我们创建第五个组，将第三个组或者第四个组中任何一个节点放到第五个组，至少有一条边连接的两个节点所属的组编号不符合题目要求。
 * 示例 2：
 * <p>
 * 输入：n = 3, edges = [[1,2],[2,3],[3,1]]
 * 输出：-1
 * 解释：如果我们将节点 1 放入第一个组，节点 2 放入第二个组，节点 3 放入第三个组，前两条边满足题目要求，但第三条边不满足题目要求。
 * 没有任何符合题目要求的分组方式。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= edges.length <= 104
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * ai != bi
 * 两个点之间至多只有一条边。
 * author:       majf
 * createDate:   2022/12/6 18:49
 * version:      1.0.0
 */
public class MagnificentSets {

    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            getEdge(edge[0], edge[1], map);
            getEdge(edge[1], edge[0], map);
        }
        int res = -1;
        int[] color = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if (color[i] == 0) {

            }
        }
        return res;
    }

    private void getEdge(int cur, int val, Map<Integer, List<Integer>> map) {
        List<Integer> list = map.get(cur);
        if (list == null) {
            list = new ArrayList<>();
            map.put(cur, list);
        }
        list.add(val);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        MagnificentSets magnificentSets = new MagnificentSets();
        System.out.println(magnificentSets.magnificentSets(n, edges));
    }
}
