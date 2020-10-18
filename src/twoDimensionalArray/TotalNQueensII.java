package twoDimensionalArray;

/**
 *description:
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
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
 *
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *author:       alex
 *createDate:   2020/10/17 13:44
 *version:      1.0.0
 */
public class TotalNQueensII {

    private int[] column;
    private int[] left;
    private int[] right;
    private int res = 0;
    public int totalNQueens(int n) {
        column =  new int[n];
        left = new int[n << 1];
        right = new int[n << 1];
        dfs(0, n);
        return res;
    }

    private void dfs(int row, int n) {
        if(row == n) {
            res++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if (column[i] == 0 && left[row - i + n] == 0 && right[row + i] == 0) {
                column[i] = 1;
                left[row - i + n] = 1;
                right[row + i] = 1;
                dfs(row + 1, n);
                column[i] = 0;
                left[row - i + n] = 0;
                right[row + i] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        TotalNQueensII totalNQueens = new TotalNQueensII();
        System.out.println(totalNQueens.totalNQueens(8));
    }
}
