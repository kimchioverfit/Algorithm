class Solution {
    fun differenceOfSum(nums: IntArray): Int {
        var elementSum = 0
        var digitSum = 0

        for(num in nums) {
            elementSum += num

            var cur = num
            while(cur > 0) {
                digitSum += cur % 10

                cur /= 10
            }
        }

        return abs(elementSum - digitSum)
    }
}
