package twoDimensionalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *description:
 *
 * N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/4 18:29
 *version:      1.0.0      
 */
public class SolveNQueens {
    //    private List<List<String>> res;
//    public List<List<String>> solveNQueens(int n) {
//        res = new ArrayList<>();
//        char[][] map = new char[n][n];
//        for (int i = 0; i < n; i++)
//            Arrays.fill(map[i], '.');
//        queen(map, 0);
//        return res;
//    }
//
//    private void queen(char[][] map, int row) {
//        if (row < 0)
//            return;
//        if (row == map.length) {
//            List<String> list = new ArrayList<>();
//            for (char[] i : map)
//                list.add(new String(i));
//            res.add(list);
//            return;
//        }
//        for (int i = 0; i < map[row].length; i++) {
//            if (judge(map, row, i)) {
//                map[row][i] = 'Q';
//                queen(map, row + 1);
//                map[row][i] = '.';
//            }
//        }
//    }
//
//    private boolean judge(char[][] map, int i, int j) {
//        int incre = 0;
//        while(i - incre >= 0) {
//            if ((j - incre >= 0 && 'Q' == (map[i -incre][j - incre])) || 'Q' == (map[i - incre][j]) || (j + incre < map[i].length && 'Q' == (map[i - incre][j + incre])))
//                return false;
//            incre++;
//        }
//        return true;
//    }
    private boolean[] column;
    private boolean[] left;
    private boolean[] right;
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n <= 0)
            return res;
        char[][] map = new char[n][n];
        for(char[] m : map)
            Arrays.fill(m, '.');
        column = new boolean[n];
        left = new boolean[n << 1];
        right = new boolean[n << 1];
        dfs(map, 0, n);
        return res;
    }

    private void dfs(char[][] map, int i, int n) {
        if(i == n) {
            List<String> list = new ArrayList<>();
            for(char[] m : map)
                list.add(new String(m));
            res.add(list);
            return;
        }
        for(int j = 0; j < n; j++) {
            if (!column[j] && !left[i + j] && !right[n + i - j]) {
                column[j] = true;
                left[i + j] = true;
                right[n + i - j] = true;
                map[i][j] = 'Q';
                dfs(map, i + 1, n);
                map[i][j] = '.';
                column[j] = false;
                left[i + j] = false;
                right[n + i - j] = false;
            }
        }
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println((solveNQueens.solveNQueens(8)));
    }
}
