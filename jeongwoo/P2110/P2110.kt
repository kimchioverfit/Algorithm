class Solution {
    fun getDescentPeriods(prices: IntArray): Long {
        val n = prices.size
        val dp = IntArray(n)

        dp[0] = 1
        for(i in 1 until n) {
            dp[i] = if(prices[i - 1] - prices[i] == 1) {
                dp[i - 1] + 1
            } else 1
        }

        var answer = 0L
        for(i in 0 until n) {
            answer += dp[i]
        }

        return answer
    }
}