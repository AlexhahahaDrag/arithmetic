package twoDimensionalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *description:  
 *author:       alex
 *createDate:   2022/4/27 23:33
 *version:      1.0.0
 */
public class PacificAtlantic {

    private int m;
    private int n;
    private int[][] h;
    List<List<Integer>> res;
    boolean[][] p ;
    boolean[][] a;
    boolean[][] ocean;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        h = heights;
        p = new boolean[m][n];
        a = new boolean[m][n];
        ocean = p;
        for(int i = 0; i < m; i++) {
            dfs(i, 0);
        }
        for(int j = 0; j < n; j++) {
            dfs(0, j);
        }
        ocean = a;
        for(int i = 0; i < m; i++) {
            dfs(i, n - 1);
        }
        for(int j = 0; j < n; j++) {
            dfs(m - 1, j);
        }
        return res;
    }

    private void dfs(int i, int j) {
        if (ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        if (a[i][j] && p[i][j]) {
            res.add(Arrays.asList(i, j));
        }
        int[][] diction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dic : diction) {
            if (dic[0] + i >= 0 && dic[0] + i < m && dic[1] + j >= 0
                    && dic[1] + j < n && h[i][j] <= h[i + dic[0]][j + dic[1]]) {
                dfs(i + dic[0], j + dic[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1}};//{{0, 0}}
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        System.out.println(pacificAtlantic.pacificAtlantic(heights));
    }
}
