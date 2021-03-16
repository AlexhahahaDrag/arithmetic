package twoDimensionalArray;

import java.util.Arrays;

/**
 *description:
 * 5211. 概率最大的路径
 *  显示英文描述
 * 我的提交
 * 返回竞赛
 * 题目难度
 * Medium
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 *
 * 示例 1：
 *
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * 输出：0.25000
 * 解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
 * 示例 2：
 *
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * 输出：0.30000
 * 示例 3：
 *
 * 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * 输出：0.00000
 * 解释：节点 0 和 节点 2 之间不存在路径
 *
 * 提示：
 * 2 <= n <= 10^4
 * 0 <= start, end < n
 * start != end
 * 0 <= a, b < n
 * a != b
 * 0 <= succProb.length == edges.length <= 2*10^4
 * 0 <= succProb[i] <= 1
 * 每两个节点之间最多有一条边
 *author:       alex
 *createDate:   2020/7/12 10:47
 *version:      1.0.0
 */
public class MaxProbability {

    private double res = 0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        boolean[] map = new boolean[n];
        find(edges, map, succProb, start, end, 1.0);
        return res;
    }

    private void find(int[][] edges, boolean[] map, double[] succProb, int start, int end, double rate) {
        if (map[start]) {
            return;
        }
        for (int i = 0; i < edges.length; i++) {
            double cur = rate;
            if (map[edges[i][0]] || map[edges[i][1]]) {
                continue;
            }
            cur *= succProb[i];
            if (edges[i][0] == start) {
                if (edges[i][1] == end) {
                    res = Math.max(res, cur);
                    return;
                } else {
                    boolean[] newMap = Arrays.copyOf(map, map.length);
                    newMap[start] = true;
                    find(edges, newMap, succProb, edges[i][1], end, cur);
                }
            }
            if (edges[i][1] == start) {
                if (edges[i][0] == end) {
                    res = Math.max(res, cur);
                    return;
                } else {
                    boolean[] newMap = Arrays.copyOf(map, map.length);
                    newMap[start] = true;
                    find(edges, newMap, succProb, edges[i][0], end, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5,0.5,0.3};
        int start = 0;
        int end = 2;
        MaxProbability maxProbability = new MaxProbability();
        System.out.println(maxProbability.maxProbability(n, edges, succProb, start, end));
    }
}
