package twoDimensionalArray;

/**
 * @description:
 * 1240. 铺瓷砖
 * 提示
 * 困难
 * 176
 * 相关企业
 * 你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 *
 * 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 *
 * 假设正方形瓷砖的规格不限，边长都是整数。
 *
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 2, m = 3
 * 输出：3
 * 解释：3 块地砖就可以铺满卧室。
 *      2 块 1x1 地砖
 *      1 块 2x2 地砖
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, m = 8
 * 输出：5
 * 示例 3：
 *
 *
 *
 * 输入：n = 11, m = 13
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= n <= 13
 * 1 <= m <= 13
 * @author:       majf
 * @createDate:   2023/6/8 18:54
 * @version:      1.0.0
 */
public class TilingRectangle {

    private int res;
    public int tilingRectangle(int n, int m) {
        res = Math.max(n, m);
        boolean[][] visited = new boolean[n][m];
        dfs(0, 0, visited, 0);
        return res;
    }

    private void dfs(int x, int y, boolean[][] visited, int count) {
        int n = visited.length;
        int m = visited[0].length;
        if (count >= res) {
            return;
        }
        if (x >= n) {
            res = count;
            return;
        }
        if (y >= m) {
            dfs(x + 1, 0, visited, count);
            return;
        }
        if (visited[x][y]) {
            dfs(x, y + 1, visited, count);
            return;
        }
        for (int i = Math.min(n - x, m - y); i >= 1 && isAvailable(x, y, visited, i); i--) {
            fill(x, y, visited, i, true);
            dfs(x, y + i, visited, count + 1);
            fill(x, y, visited, i, false);
        }
    }

    private boolean isAvailable(int x, int y, boolean[][] visited, int l) {
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                if (visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void fill(int x, int y, boolean[][] visited, int l, boolean value) {
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                visited[i][j] = value;
            }
        }
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 13;
        TilingRectangle tilingRectangle = new TilingRectangle();
        System.out.println(tilingRectangle.tilingRectangle(n, m));
    }
}
