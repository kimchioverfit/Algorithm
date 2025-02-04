/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1517724826/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = (int) Math.pow(10, 5) + 1;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (minPrice > price) {
                minPrice = price;
            }

            result = (result > price - minPrice) ? result : price - minPrice;
        }
        return result;

    }
}