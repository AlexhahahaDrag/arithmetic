package math;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *description:  688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 *
 *
 * 提示:
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 *author:       alex
 *createDate:   2022/2/18 17:39
 *version:      1.0.0
 */
public class KnightProbability {

    public double knightProbability(int n, int k, int row, int column) {
        Queue<Info> query = new LinkedList<>();
        query.add(new Info(row, column));
        double res = 0;
        int size;
        double rate = 0.125;
        int[][] dictionary = {{-1, -2}, {-1, 2}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        while(!query.isEmpty() && k-- > 0) {
            size = query.size();
            while(size-- > 0) {
                Info info = query.poll();
                for(int[] dic : dictionary) {
                    if (dic[0] + info.row < 0 || dic[0] + info.row >= n || dic[1] + info.column < 0 || dic[1] + info.column >= n) {
                        res += rate;
                    } else {
                        query.add(new Info(dic[0] + info.row, dic[1] + info.column));
                    }
                }
            }
            rate *= rate;
        }
        System.out.println(query.size() * rate);
        return 1 - res;
    }

    class Info {
        int row;
        int column;

        public Info(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
//        int n = 3;
//        int k = 2;
//        int row = 0;
//        int column = 0;//0.0625
        int n = 3;
        int k = 3;
        int row = 0;
        int column = 0;//0.01562
        KnightProbability knightProbability = new KnightProbability();
        System.out.println(knightProbability.knightProbability(n, k, row, column));
    }
}
