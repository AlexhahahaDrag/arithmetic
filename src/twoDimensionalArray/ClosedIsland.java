package twoDimensionalArray;

/**
 * @Description:
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 *
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 *
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 *
 * 请返回封闭岛屿的数目。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 *              [1,1,1,1,1,1,1]]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/11/6 16:43
 * @Version:    1.0
 *
 */
public class ClosedIsland {

    public static void main(String[] args) {
        ClosedIsland closedIsland = new ClosedIsland();
        int[][] grid = {{1,1,1,1,1,1,1}, {1,0,0,0,0,0,1}, {1,0,1,1,1,0,1}, {1,0,1,0,1,0,1}, {1,0,1,1,1,0,1}, {1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
        System.out.println(closedIsland.closedIsland(grid));
    }
    boolean flag;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int closedIsland(int[][] grid) {
        int islandNum = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    flag = true;
                    searchIsland(grid, i, j);
                    if (flag) {
                        islandNum++;
                    }
                }
            }
        }
        return islandNum;
    }
    private void searchIsland (int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            flag = false;
            return;
        }
        if(grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        for(int[] dir : direction) {
            searchIsland(grid, x + dir[0], y + dir[1]);
        }
    }
}
