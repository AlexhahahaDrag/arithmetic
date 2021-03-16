package array;

import java.util.Arrays;

/**
 * @Description: Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * @Author:     alex
 * @CreateDate: 2019/7/31 11:23
 * @Version:    1.0
 *
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E', 'E'}};
        System.out.println(wordSearch.exist(arr, "SEE"));
    }
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length + 2][board[0].length + 2];
        if (word == null) {
            return true;
        }
        if (board == null || board.length == 0) {
            return false;
        }
        char[][] chars = new char[board.length + 2][];
        chars[0] = new char[board[0].length + 2];
        chars[board.length + 1] = new char[board[board.length - 1].length + 2];
        for (int i = 1; i < chars.length - 1; i++) {
            chars[i] = new char[board[i - 1].length + 2];
            for (int j = 1; j < chars[i].length - 1; j++) {
                chars[i][j] = board[i - 1][j -1];
            }
        }
        for(int i = 1; i < chars.length - 1; i++) {
            for(int j = 1; j < chars[i].length - 1; j++) {
                if ((word.charAt(0) == chars[i][j]) && search(chars, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][]chars, String word, int i, int j, int index){
        if(index == word.length()) {
            return true;
        }
        if(chars[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(search(chars, word, i-1, j, index+1) ||
                search(chars, word, i+1, j, index+1) ||
                search(chars, word, i, j-1, index+1) ||
                search(chars, word, i, j+1, index+1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

}
