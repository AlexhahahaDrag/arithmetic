package array;

/**
 * Description:
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * Author:      alex
 * CreateDate:  2020/7/10 12:32
 * Version:     1.0
 *
*/
public class MaxProfitIIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //表示第i天手上有股票的收益
        int f1 = -prices[0];
        //表示第i天手上无股票，且处于冻结状态的收益
        int f2 = 0;
        //表示第i天手上无股票，且不处于冻结状态的收益
        int f3 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newF1 = Math.max(f1, f3 - prices[i]);
            int newF2 = f1 + prices[i];
            int newF3 = Math.max(f2, f3);
            f1 = newF1;
            f2 = newF2;
            f3 = newF3;
        }
        return Math.max(f2, f3);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        MaxProfitIIII maxProfitIIII = new MaxProfitIIII();
        System.out.println(maxProfitIIII.maxProfit(prices));
    }
}
