package array;

/**
 * @description:
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * @author:      alex
 * @createTime:  2020/12/17 17:00
 * @version:     1.0
 */
public class MaxProfitV {

    public int maxProfit1(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(prices[i] + buy[i - 1] - fee, sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int newSell = Math.max(prices[i] + buy - fee, sell);
            int newBuy = Math.max(buy, sell - prices[i]);
            sell = newSell;
            buy = newBuy;
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        MaxProfitV maxProfitV = new MaxProfitV();
        System.out.println(maxProfitV.maxProfit(prices, fee));
    }
}
