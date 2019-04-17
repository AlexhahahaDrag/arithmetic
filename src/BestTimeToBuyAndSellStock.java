import java.util.Stack;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices={7};
        System.out.println(maxProfit1(prices));
    }
    public static int maxProfit(int[] prices){
        int targetNum=0;
        for(int i=0;i<prices.length;i++){
            int thisNum;
            for(int j=i+1;j<prices.length;j++){
                thisNum=prices[j]-prices[i];
                if(targetNum<thisNum){
                    targetNum=thisNum;
                }
            }
        }
        return targetNum;
    }
    public static int maxProfit1(int[] prices){
        int min=prices[0];
        int targetNum=0;
        for(int i=0;i<prices.length;i++){
            targetNum=targetNum>prices[i]-min?targetNum:prices[i]-min;
            min=min>prices[i]?prices[i]:min;
        }
        return targetNum;
    }
}
