class Solution {
    fun maximumDifference(nums: IntArray): Int {
        var answer = -1
        var previousMin = nums[0]

        for(i in 1 until nums.size) {
            if(nums[i] > previousMin) {
                answer = max(answer, nums[i] - previousMin)
            } else {
                previousMin = min(nums[i], previousMin)
            }
        }

        return answer
    }
}
