package 剑指offer;

public class offer_63 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price: prices) {
            cost = Math.min(cost, price); // 前几日的最小收入价格
            profit = Math.max(profit, price - cost); // 计算收益的最大值 dp[i] = max(dp[i - 1], prices[i] - cost)
        }
        return profit;
    }
}
