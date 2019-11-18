package twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[i].length <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/11/18 9:34
 * @Version:    1.0
 *
*/
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k = k % (grid.length * grid[0].length);
        int[][] map = new int[grid.length][grid[0].length];
        int digit = 0;
        for(int i = 0; i <grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                digit = (k +j) / grid[0].length;
                map[(i + digit) % grid.length][(k + j) % grid[0].length] = grid[i][j];
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <map.length; i++) {
            List<Integer> ls = new ArrayList<>();
            for(int j = 0; j < map[0].length; j++) {
                ls.add(map[i][j]);
            }
            list.add(ls);
        }
        return list;
    }
}
