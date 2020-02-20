package twoDimensionalArray;

/**
 *description:
 * 参加考试的最大学生数 显示英文描述
 * 用户通过次数40
 * 用户尝试次数100
 * 通过次数40
 * 提交次数147
 * 题目难度Hard
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 *
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
 *
 * 学生必须坐在状况良好的座位上。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：seats = [["#",".","#","#",".","#"],
 *               [".","#","#","#","#","."],
 *               ["#",".","#","#",".","#"]]
 * 输出：4
 * 解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
 * 示例 2：
 *
 * 输入：seats = [[".","#"],
 *               ["#","#"],
 *               ["#","."],
 *               ["#","#"],
 *               [".","#"]]
 * 输出：3
 * 解释：让所有学生坐在可用的座位上。
 * 示例 3：
 *
 * 输入：seats = [["#",".",".",".","#"],
 *               [".","#",".","#","."],
 *               [".",".","#",".","."],
 *               [".","#",".","#","."],
 *               ["#",".",".",".","#"]]
 * 输出：10
 * 解释：让学生坐在第 1、3 和 5 列的可用座位上。
 *
 *
 * 提示：
 *
 * seats 只包含字符 '.' 和'#'
 * m == seats.length
 * n == seats[i].length
 * 1 <= m <= 8
 * 1 <= n <= 8
 *author:       alex
 *createDate:  2020/2/9 11:27
 *version:      1.0.0      
*/
public class MaxStudents {

    int maxNum = 0;
    public int maxStudents(char[][] seats) {
        char[][] seatsM = new char[seats.length + 2][seats[0].length + 2];
        for (int i = 0; i < seatsM.length; i++) {
            seatsM[i][0] = '#';
            seatsM[i][seatsM[0].length - 1] = '#';
        }
        for (int j = 0; j < seatsM[0].length; j++) {
            seatsM[0][j] = '#';
            seatsM[seatsM.length - 1][j] = '#';
        }
        for (int k = 1; k < seatsM.length - 1; k++) {
            for (int l = 1; l < seatsM[k].length - 1; l++) {
                seatsM[k][l] = seats[k - 1][l - 1];
            }
        }
        int[][] map = new int[seatsM.length][seatsM[0].length];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {

            }
        }
        /*dfs(seats, map, 0, 0 ,0);*/
        return maxNum;
    }

   /* private int dfs(char[][] seats, int[][] map, int row, int column, int num) {
        for (int i = row; i < seats.length; i++) {
            for (int j = column; j < seats[i].length; j++) {
                if (seats[i][j] == '#') {

                }
            }
        }
    }*/

    private void find(char[][] seats, int[][] map, int row, int column, int num) {
        if (column - 1 >= 0) {
            if (column + 1 < seats[row].length) {

            }
        }
    }

    public static void main(String[] args) {
        MaxStudents maxStudents = new MaxStudents();
        char[][] seats = {{'#','.','#','#','.','#'}, {'.','#','#','#','#','.'}, {'#','.','#','#','.','#'}};
        System.out.println(maxStudents.maxStudents(seats));
    }
}
