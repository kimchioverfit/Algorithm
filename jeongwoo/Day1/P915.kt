package Day1

import kotlin.math.max

class P915 {
    fun partitionDisjoint(nums: IntArray): Int {
        var currentMaxValue = Int.MIN_VALUE

        for(i in 0 until nums.size) {
            currentMaxValue = max(nums[i], currentMaxValue)

            var flag = true
            for(j in (i + 1) until nums.size) {
                if(currentMaxValue > nums[j]) {
                    flag = false
                    break
                }
            }

            if(flag) return (i + 1)
        }

        return 0
    }
}