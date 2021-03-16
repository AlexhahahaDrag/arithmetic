package array;

/**
 * @Description:
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * @Author:     alex
 * @CreateDate: 2019/8/21 17:36
 * @Version:    1.0
 *
*/
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] arr = {{'1', '1', '1', '1'}, {'1', '0', '0', '0'}, {'1', '0', '1', '0'}, {'1', '0', '1', '0'}};
        System.out.println(numberOfIslands.numIslands(arr));
    }

    public int numIslands(char[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        char[][] moreArr = new char[arr.length + 2][arr[0].length + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                moreArr[i + 1][j + 1] = arr[i][j];
            }
        }
        boolean[][] map = new boolean[moreArr.length][moreArr[0].length];
        int count = 0;
        for (int i = 1; i < moreArr.length - 1; i++) {
            for (int j = 1; j < moreArr[i].length - 1; j++) {
                if (!map[i][j] && moreArr[i][j] == '1') {
                    map(moreArr, map, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void map(char[][] arr,boolean[][] map, int i, int j) {
        if (!map[i][j] && arr[i][j] == '1') {
            map[i][j] = true;
            map(arr, map, i - 1, j);
            map(arr, map, i + 1, j);
            map(arr, map, i, j - 1);
            map(arr, map, i, j + 1);
        }
    }

    public int numIslands1(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int i, int j){
        if(i < 0 || j < 0 || i >= grid.length||j >= grid[0].length|| grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
    }

}
