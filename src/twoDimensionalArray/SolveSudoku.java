package twoDimensionalArray;

/**
 * @description:
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * @author:      alex
 * @createTime:  2020/9/15 14:22
 * @version:     1.0
 */
public class SolveSudoku {
    boolean[][][] map;
    public void solveSudoku(char[][] board) {
        map = new boolean[3][9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    map[0][i][board[i][j] - '0' - 1] = true;
                    map[1][j][board[i][j] - '0' - 1] = true;
                    map[2][i / 3 * 3 + j / 3][board[i][j] - '0' - 1] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                if (!map[0][i][k] && !map[1][j][k] && !map[2][i / 3  * 3 + j / 3][k]) {
                    map[0][i][k] = true;
                    map[1][j][k] = true;
                    map[2][i / 3 * 3 + j / 3][k] = true;
                    board[i][j] = (char)(k + '1');
                    if (search(board, i, j)) {
                        return true;
                    } else {
                        map[0][i][k] = false;
                        map[1][j][k] = false;
                        board[i][j] = '.';
                        map[2][i / 3  * 3 + j / 3][k] = false;
                    }
                }
            }
        } else {
            return search(board, i, j);
        }
        return false;
    }

    private boolean search (char[][] board, int i, int j) {
        if (i + 1 == board.length && j + 1 == board[i].length) {
            return true;
        } else if (j + 1 == board.length) {
            return dfs(board, i + 1, 0);
        } else {
            return dfs(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
        for (char[] ch : board) {
            for (char c : ch) {
                System.out.print(c + "   ");
            }
            System.out.println();
        }
    }
}
