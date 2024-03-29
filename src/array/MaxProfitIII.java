package array;


/**
 * @description:
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * @author:      alex
 * @createTime:  2020/11/12 19:43
 * @version:     1.0
 */
public class MaxProfitIII {

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int[] db0 = new int[len];
        db0[0] -= prices[0];
        int[] dp1 = new int[len];
        int[] db1 = new int[len];
        db1[1] = Integer.MIN_VALUE;
        int[] dp2 = new int[len];
        for(int i = 1; i < prices.length; i++) {
            //0买入最小值
            db0[i] = Math.max(db0[i - 1], -prices[i]);
            //1卖出最大值
            dp1[i] = Math.max(dp1[i - 1], db0[i - 1] + prices[i]);
            //1买入最大值
            if (i > 1) {
                db1[i] = Math.max(db1[i - 1], dp1[i - 1] - prices[i]);
            }
            //2卖出最大值
            if (i > 2) {
                dp2[i] = Math.max(dp2[i - 1], db1[i - 1] + prices[i]);
            }
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int db0 = -prices[0];
        int dp1 = Integer.MIN_VALUE;
        int db1 = Integer.MIN_VALUE;
        int dp2 = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            //0买入最小值
            db0 = Math.max(db0, -prices[i]);
            //1卖出最大值
            dp1 = Math.max(dp1, db0 + prices[i]);
            //1买入最大值
            if (i > 1) {
                db1 = Math.max(db1, dp1 - prices[i]);
            }
            //2卖出最大值
            if (i > 2) {
                dp2 = Math.max(dp2, db1 + prices[i]);
            }
        }
        return Math.max(dp1, dp2);
    }

    public int maxProfit(int[] prices) {
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i10 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        for(int i = 0; i < prices.length; i++) {
            //2卖出最大值
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            //1买入最大值
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            //1卖出最大值
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            //0买入最小值
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }
        return dp_i20;
    }

    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {1, 7,4,3,1};
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        System.out.println(maxProfitIII.maxProfit(prices));
    }
}
