package string_array;

/**
 *description:
 * 794. 有效的井字游戏
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 *
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * 示例 2：
 *
 *
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * 示例 3：
 *
 *
 * 输入：board = ["XXX","   ","OOO"]
 * 输出：false
 * Example 4:
 *
 *
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 *author:       alex
 *createDate:   2021/12/9 10:30
 *version:      1.0.0
 */
public class ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        int[] row = new int[3];
        int[] column = new int[3];
        int[] xy = new int[2];
        int cur;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cur = (board[i].charAt(j) == 'X' ? 1 : (board[i].charAt(j) == 'O' ? - 1 : 0));
                if (cur == 1) {
                    x++;
                } else if (cur == -1) {
                    o++;
                }
                row[i] += cur;
                column[j] += cur;
                if (i == j) {
                    xy[0]+= cur;
                }
                if (i + j == 2) {
                    xy[1] += cur;
                }
            }
        }
        if (x - o < 0 || x - o > 1) {
            return false;
        }
        boolean of = false;
        boolean xf = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 3) {
                xf = true;
            }
            if (row[i] == -3) {
                of = true;
            }
        }
        for (int i = 0; i < column.length; i++) {
            if (column[i] == 3) {
                xf = true;
            }
            if (column[i] == -3) {
                of = true;
            }
        }
        for (int i = 0; i < xy.length; i++) {
            if (xy[i] == 3) {
                xf = true;
            }
            if (xy[i] == -3) {
                of = true;
            }
        }
        if (xf && x == o) {
            return false;
        }
        if (of && x > o) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] board = {"XO ","X  ","   "};//true
//        String[] board = {"XXX","OOX","OOX"};//true
//        String[] board = {"OXX","XOX","OXO"};//false
        String[] board = {"XO ","XO ","XO "};//false
//        String[] board = {"XOX","OXO","XOX"}; // true
//        String[] board = {"XOX","O X","X O"}; //true
//        String[] board = {"XOX"," X ","   "};//false
//        String[] board = {"XOX","X O","X O"};//true
        ValidTicTacToe validTicTacToe = new ValidTicTacToe();
        System.out.println(validTicTacToe.validTicTacToe(board));
    }
}
