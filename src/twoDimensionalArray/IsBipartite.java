package twoDimensionalArray;

/**
 *description:
 *785. 判断二分图
 * 难度
 * 中等
 *
 * 117
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 *author:       alex
 *createDate:  2020/7/16 11:17
 *version:      1.0.0
 */
public class IsBipartite {
    private boolean valid;
    int[] map;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        map = new int[n];
        valid = true;
        for (int i = 0; i < n && valid; i++) {
            if (map[i] == 0) {
                dfs(graph, i, 1);
            }
        }
        return valid;
    }

    private void dfs(int[][] graph, int index, int co) {
        map[index] = co;
        int cur = co == 1 ? 2 : 1;
        for (int i : graph[index]) {
            if (map[i] == 0) {
                dfs(graph, i, cur);
                if (!valid) {
                    return;
                }
            } else if (map[i] != cur) {
                valid = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{}, {3}, {}, {0}, {}};
        IsBipartite isBipartite = new IsBipartite();
        System.out.println(isBipartite.isBipartite(graph));
    }
}
