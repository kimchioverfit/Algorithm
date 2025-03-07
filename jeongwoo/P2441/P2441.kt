class Solution {
    fun findMaxK(nums: IntArray): Int {
        val sorted = nums.sorted()

        var left = 0
        var right = nums.size - 1

        while(left <= right) {
            if(sorted[left] > 0 || sorted[right] < 0) return -1

            if(sorted[left] + sorted[right] == 0) {
                return sorted[right]
            }

            if(sorted[left] * -1 > sorted[right]) {
                left++
            } else {
                right--
            }
        }

        return -1
    }
}