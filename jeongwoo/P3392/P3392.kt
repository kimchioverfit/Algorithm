class Solution {
    fun countSubarrays(nums: IntArray): Int {
        var answer = 0

        for(i in 0 until (nums.size - 2)) {
            if((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                answer += 1
            }
        }

        return answer
    }
}
