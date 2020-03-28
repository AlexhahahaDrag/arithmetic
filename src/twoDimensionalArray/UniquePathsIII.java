package twoDimensionalArray;

/**
 *description:
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 *
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 *
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 *
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 *
 *
 * 提示：
 *
 * 1 <= grid.length * grid[0].length <= 20
 *author:       alex
 *createDate:  2020/3/28 13:25
 *version:      1.0.0      
*/
public class UniquePathsIII {

    int num = 0;
    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int is = 0;
        int js = 0;
        int row = grid.length;
        int column = grid[0].length;
        int obs = 0;
        boolean[][] map = new boolean[row][column];
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < column; l++) {
                if (grid[k][l] == 1) {
                    is = k;
                    js = l;
                }else if (grid[k][l] == -1)
                    obs++;
            }
        }
        dfs(is, js, grid, row * column - obs - 1, map);
        return num;
    }


    private void dfs(int i, int j, int[][] grid, int obs, boolean[][] map) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || map[i][j])
            return;
        if (grid[i][j] == 2) {
            if (obs == 0)
                num++;
            return;
        }
        map[i][j] = true;
        dfs(i - 1, j, grid, obs - 1, map);
        dfs(i, j - 1, grid, obs - 1, map);
        dfs(i + 1, j, grid, obs - 1, map);
        dfs(i, j + 1, grid, obs - 1, map);
        map[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {2, 0}};
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        System.out.println(uniquePathsIII.uniquePathsIII(grid));
    }
}
