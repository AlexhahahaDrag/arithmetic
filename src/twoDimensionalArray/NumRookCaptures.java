package twoDimensionalArray;

/**
 *description:
 *
 * 999. 车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * 示例 2：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：0
 * 解释：
 * 象阻止了车捕获任何卒。
 * 示例 3：
 *
 *
 *
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 车可以捕获位置 b5，d6 和 f5 的卒。
 *
 *
 * 提示：
 *
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 *author:       alex
 *createDate:  2020/3/26 22:24
 *version:      1.0.0      
*/
public class NumRookCaptures {

    int max = 0;
    public int numRookCaptures(char[][] board) {
        int[] row = {-1, 1};
        int[] column = {-1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    findRow(board, i, j, 1, row);
                    findColumn(board, i, j, 1, column);
                    return max;
                }
            }
        }
        return -1;
    }

    private void findRow(char[][] board, int i, int j, int move, int[] map) {
        int exe = 0;
        for (int k = 0; k < map.length; k++) {
            if (map[k] == 0) {
                continue;
            }
            int index = i + map[k] * move;
            if (index < 0 || index >= board.length || board[index][j] == 'B') {
                map[k] = 0;
                continue;
            }
            if (board[index][j] == 'p') {
                max++;
                map[k] = 0;
                continue;
            }
            exe++;
        }
        if (exe != 0) {
            findRow(board, i, j, move + 1, map);
        }
    }

    private void findColumn(char[][] board, int i, int j, int move, int[] map) {
        int exe = 0;
        for (int k = 0; k < map.length; k++) {
            if (map[k] == 0) {
                continue;
            }
            int index = j + map[k] * move;
            if (index < 0 || index >= board[i].length || board[i][index] == 'B') {
                map[k] = 0;
                continue;
            }
            if (board[i][index] == 'p') {
                max++;
                map[k] = 0;
                continue;
            }
            exe++;
        }
        if (exe != 0) {
            findColumn(board, i, j, move + 1, map);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        NumRookCaptures numRookCaptures = new NumRookCaptures();
        System.out.println(numRookCaptures.numRookCaptures(board));
    }
}
