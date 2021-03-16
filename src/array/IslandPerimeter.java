package array;

/**
 * @description:
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * @author:      alex
 * @createTime:  2020/10/30 14:24
 * @version:     1.0
 */
public class IslandPerimeter {

    private int len = 0;
    private boolean[][] visited;
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return len;
        }
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
                }
            }
        }
        return len;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        len += 4;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            len--;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            len--;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            len--;
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            len--;
        }
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int islandPerimeter(int[][] grid) {
        int ml = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ml;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ml += 4;
                    if (i - 1>= 0 && grid[i - 1][j] == 1) {
                        ml -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        ml -= 2;
                    }
                }
            }
        }
        return ml;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
//        int[][] grid = {{0,1}};
//        int[][] grid = {{1, 1}, {1, 1}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(grid));
    }
}
