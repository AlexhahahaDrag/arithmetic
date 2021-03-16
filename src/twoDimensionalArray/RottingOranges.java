package twoDimensionalArray;
/**
 * @Description: In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * @Author:      alex
 * @CreateDate:  2019/5/22 10:08
 * @param
 * @return
*/
public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rottingOranges=new RottingOranges();
        int[][] grid={{2},{2},{1},{0},{1},{1}};
        System.out.println(rottingOranges.orangesRotting1(grid));
    }
    public int orangesRotting1(int[][] grid) {
        boolean hasFreshOrange;
        boolean becomeRotOrange;
        int rot=2;
        int[][] gridMore=new int[grid.length+2][grid[0].length+2];
        for(int i=1;i<gridMore.length-1;i++) {
            for(int j=1;j<gridMore[i].length-1;j++) {
                gridMore[i][j] = grid[i - 1][j - 1];
            }
        }
        int minute=0;
        do{
            hasFreshOrange=false;
            becomeRotOrange=false;
            for(int i=1;i<gridMore.length-1;i++) {
                for (int j = 1; j < gridMore[i].length - 1; j++) {
                    if (gridMore[i][j] == rot) {
                        if (gridMore[i - 1][j] == 1) {
                            gridMore[i - 1][j] = rot+1;
                            becomeRotOrange=true;
                        }
                        if (gridMore[i + 1][j] == 1) {
                            gridMore[i + 1][j] = rot+1;
                            becomeRotOrange=true;
                        }
                        if (gridMore[i][j - 1] == 1) {
                            gridMore[i][j - 1] =rot+1;
                            becomeRotOrange=true;
                        }
                        if (gridMore[i][j + 1] == 1) {
                            gridMore[i][j + 1] = rot+1;
                            becomeRotOrange=true;
                        }
                    }else if (gridMore[i][j]==1) {
                        hasFreshOrange=true;
                    }
                }
            }
            rot++;
            if (becomeRotOrange) {
                minute++;
            }
        }while (hasFreshOrange&&becomeRotOrange);
        if (hasFreshOrange) {
            return -1;
        }
        return minute;
    }
}
