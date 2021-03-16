package twoDimensionalArray;

/**
 *description:
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *author:       alex
 *createDate:  2020/3/25 9:01
 *version:      1.0.0
*/
public class SurfaceArea {

    public int surfaceArea1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] map = new int[grid.length][grid[0].length];
        if (grid[0][0] != 0) {
            map[0][0] = 4 * grid[0][0] + 2;
        }
        for (int i = 1; i < grid.length; i++) {
            map[i][0] = map[i - 1][0];
            if(grid[i][0] != 0) {
                map[i][0] += 4 * grid[i][0] + 2 - 2 * Math.min(grid[i][0], grid[i - 1][0]);
            }
        }
        for (int j = 1; j < grid[0].length; j++)  {
            map[0][j] = map[0][j - 1];
            if (grid[0][j] != 0) {
                map[0][j] += 4 * grid[0][j] + 2 - 2 * Math.min(grid[0][j], grid[0][j - 1]);
            }
        }
        for(int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][ j -1];
                if (grid[i][j] != 0) {
                    map[i][j] += 4 * grid[i][j] + 2 - 2 * (Math.min(grid[i][j], grid[i - 1][j]) + Math.min(grid[i][j], grid[i][j - 1]));
                }
            }
        }
        return map[grid.length - 1][grid[0].length - 1];
    }

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += findSurface(grid, i, j);
            }
        }
        return sum;
    }

    private int findSurface(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int cur = 4 * grid[i][j] + 2;
        if (i - 1 >= 0) {
            cur -= 2 * Math.min(grid[i - 1][j], grid[i][j]);
        }
        if (j - 1 >= 0) {
            cur -= 2 * Math.min(grid[i][j - 1], grid[i][j]);
        }
        return cur;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        SurfaceArea surfaceArea = new SurfaceArea();
        System.out.println(surfaceArea.surfaceArea(arr));
    }
}
