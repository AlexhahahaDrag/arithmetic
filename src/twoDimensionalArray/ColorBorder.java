package twoDimensionalArray;

/**
 *description:  1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 *
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *author:       alex
 *createDate:   2021/12/7 15:56
 *version:      1.0.0
 */
public class ColorBorder {

    private int[][] visited1;
    public int[][] colorBorder1(int[][] grid, int row, int col, int color) {
        //1代表访问过、2代表是边
        visited1 = new int[grid.length][grid[0].length];
        dfs1(grid, row, col, grid[row][col]);
        for (int i = 0; i < visited1.length; i++) {
            for (int j = 0; j < visited1[i].length; j++) {
                if (visited1[i][j] == 2) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private boolean dfs1(int[][] grid, int r, int c, int cur) {
        if (r < 0 || r >= grid.length ||c < 0 || c >= grid[r].length || grid[r][c] != cur) {
            return true;
        }
        //如果当前值等于grid[r][c]
        if (visited1[r][c] == 1) {
            return false;
        }
        //设置当前节点为访问过
        visited1[r][c] = 1;
        //如果四个方向有一个方向是边的时候，该节点为边
        if (dfs1(grid, r - 1, c, cur) | dfs1(grid, r + 1, c, cur) | dfs1(grid, r, c - 1, cur) | dfs1(grid, r, c + 1, cur)) {
            visited1[r][c] = 2;
        }
        return false;
    }

    private boolean[][] visited;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //1代表访问过、2代表是边
        visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, grid[row][col], color);
        return grid;
    }

    private boolean dfs(int[][] grid, int r, int c, int cur, int color) {
        if (r < 0 || r >= grid.length ||c < 0 || c >= grid[r].length) {
            return true;
        }
        //如果当前值等于grid[r][c]
        if (visited[r][c]) {
            return false;
        }
        if (grid[r][c] != cur) {
            return true;
        }
        //设置当前节点为访问过
        visited[r][c] = true;
        //如果四个方向有一个方向是边的时候，该节点为边
        if (dfs(grid, r - 1, c, cur, color) | dfs(grid, r + 1, c, cur, color) | dfs(grid, r, c - 1, cur, color) | dfs(grid, r, c + 1, cur, color)) {
            grid[r][c] = color;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1}, {1,1,1}, {1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2;
        ColorBorder colorBorder = new ColorBorder();
        int[][] res = colorBorder.colorBorder(grid, row, col, color);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + ",");
            }
            System.out.println();
        }
    }
}
