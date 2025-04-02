class Solution {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var answer = 0

        var count = 0
        var isEvenOdd = false
        for(i in 0 until nums.size) {
            if(isEvenOdd) {
                if((nums[i - 1] % 2) == (nums[i] % 2) || (nums[i] > threshold)) {
                    answer = max(answer, count)
                    isEvenOdd = false
                } else {
                    count += 1
                }
            } 
            
            if(!isEvenOdd) {
                if(nums[i] % 2 == 0 && nums[i] <= threshold) {
                    isEvenOdd = true
                    count = 1
                }
            }
        }

        if(isEvenOdd) {
            answer = max(answer, count)
        }

        return answer
    }
}