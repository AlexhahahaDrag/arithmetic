package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 *description:
 * 6076. 表示一个折线图的最少线段数
 * 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
 *
 *
 * 请你返回要表示一个折线图所需要的 最少线段数 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
 * 输出：3
 * 解释：
 * 上图为输入对应的图，横坐标表示日期，纵坐标表示价格。
 * 以下 3 个线段可以表示折线图：
 * - 线段 1 （红色）从 (1,7) 到 (4,4) ，经过 (1,7) ，(2,6) ，(3,5) 和 (4,4) 。
 * - 线段 2 （蓝色）从 (4,4) 到 (5,4) 。
 * - 线段 3 （绿色）从 (5,4) 到 (8,1) ，经过 (5,4) ，(6,3) ，(7,2) 和 (8,1) 。
 * 可以证明，无法用少于 3 条线段表示这个折线图。
 * 示例 2：
 *
 *
 *
 * 输入：stockPrices = [[3,4],[1,2],[7,8],[2,3]]
 * 输出：1
 * 解释：
 * 如上图所示，折线图可以用一条线段表示。
 *
 *
 * 提示：
 *
 * 1 <= stockPrices.length <= 105
 * stockPrices[i].length == 2
 * 1 <= dayi, pricei <= 109
 * 所有 dayi 互不相同 。
 *author:       alex
 *createDate:   2022/5/22 15:35
 *version:      1.0.0
 */
public class MinimumLines {

    public int minimumLines(int[][] sp) {
        if(sp.length == 1) {
            return 0;
        }
        if(sp.length == 2) {
            return 1;
        }
        Arrays.sort(sp, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        int[] pre = sp[1];
        long x = sp[1][0] - sp[0][0];
        long y = sp[1][1] - sp[0][1];
        for(int i = 2; i < sp.length; i++) {
            int curx = sp[i][0] - pre[0];
            int cury = sp[i][1] - pre[1];
            if (x * cury != y * curx) {
                res++;
                x = curx;
                y = cury;
            }
            pre = sp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] sp = {{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        MinimumLines minimumLines = new MinimumLines();
        System.out.println(minimumLines.minimumLines(sp));
    }
}
