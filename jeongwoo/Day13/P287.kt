class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val isDuplicated = BooleanArray(nums.size)

        for(num in nums) {
            if(isDuplicated[num]) return num

            isDuplicated[num] = true
        }

        return 0
    }
}