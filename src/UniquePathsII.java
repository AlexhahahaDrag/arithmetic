/**
 * @Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * {
 *   {0,0,0},
 *   {0,1,0},
 *   {0,0,0}
 * }
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * @Author:      alex
 * @CreateDate:  2019/5/14 10:30
 * @param
 * @return
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid={{1,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            if (obstacleGrid[i][0]==1) {
                break;
            }
            map[i][0]=1;
        }
        for(int j=0;j<obstacleGrid[0].length;j++){
            if (obstacleGrid[0][j]==1) {
                break;
            }
            map[0][j]=1;
        }
        for(int k=1;k<obstacleGrid.length;k++) {
            for(int l=1;l<obstacleGrid[k].length;l++) {
                if (obstacleGrid[k][l] != 1) {
                    map[k][l] = map[k - 1][l] + map[k][l - 1];
                }
            }
        }
        return map[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
