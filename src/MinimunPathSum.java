/**
 * @Description: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * @Author:      alex
 * @CreateDate:  2019/5/13 17:01
 * @param
 * @return
 */
public class MinimunPathSum {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int[][] memo=new int[grid.length][grid[0].length];
                int x=minPathSumHelper(grid,0,0,memo);
                return x;
    }

    public static int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if (row==grid.length-1&&col==grid[0].length-1) {
            return grid[row][col];
        }
        if (memo[row][col]!=0) {
            return memo[row][col];
        }
        int rowNum=Integer.MAX_VALUE;
        int colNum=Integer.MAX_VALUE;
        if (row<grid.length-1) {
            rowNum=minPathSumHelper(grid,row+1,col,memo);
        }
        if (col<grid[0].length-1) {
            colNum=minPathSumHelper(grid,row,col+1,memo);
        }
        memo[row][col]=Math.min(rowNum,colNum)+grid[row][col];
        return memo[row][col];
    }
}
