class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var prev = Int.MAX_VALUE

        var count = 0
        var answer = 0

        for(num in nums) {
            if(prev >= num) {
                answer = max(answer, count)
                count = 1
            } else {
                count += 1
            }

            prev = num
        }
        answer = max(answer, count)

        return answer
    }
}