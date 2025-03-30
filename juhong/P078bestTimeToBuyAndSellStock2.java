/** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

class Solution {
    public int maxProfit(int[] prices) {
    	int result = 0;
    	int prevPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
        	if (prevPrice < prices[i]) {
        		result += prices[i] - prevPrice;
        	}
        	prevPrice = prices[i];
        }
        return result;
    }
}