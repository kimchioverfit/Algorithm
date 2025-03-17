class Solution {
    fun divideArray(nums: IntArray): Boolean {
        val isPair = BooleanArray(501)

        for(num in nums) {
            isPair[num] = !isPair[num]
        }

        for(i in 1..500) {
            if(isPair[i]) return false
        }

        return true
    }
}
