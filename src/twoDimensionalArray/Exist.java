package twoDimensionalArray;

/**
 * @description:
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * @author:      alex
 * @createTime:  2020/9/18 16:22
 * @version:     1.0
 */
public class Exist {

    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0] && dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] words, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] != words[index]) {
            return false;
        }
        if (++index == words.length) {
            return true;
        }
        visited[i][j] = true;
        boolean flag = false;
        if (i - 1 >= 0) {
            flag = dfs(board, i - 1, j, words, index);
        }
        if (!flag && i + 1 < board.length) {
            flag = dfs(board, i + 1, j, words, index);
        }
        if (!flag && j - 1 >= 0) {
            flag = dfs(board, i, j - 1, words, index);
        }
        if (!flag && j + 1 < board[i].length) {
            flag = dfs(board, i, j + 1, words, index);
        }
        visited[i][j] = false;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char[][] board = {{'A'}};
//        String word = "A";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCB";
//        char[][] board = {{'A','B'}};
//        String word = "AB";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
    }
}
