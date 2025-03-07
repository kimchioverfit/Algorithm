class Solution {
    fun sumOfSquares(nums: IntArray): Int {
        val n = nums.size

        var answer = 0

        for(i in 0 until n) {
            if(n % (i + 1) == 0) answer += (nums[i] * nums[i])
        }

        return answer
    }
}
