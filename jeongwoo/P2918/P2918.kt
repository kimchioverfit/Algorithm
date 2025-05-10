class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var sum1 = 0L
        var sum2 = 0L
        var zero1 = 0L
        var zero2 = 0L

        nums1.forEach { num ->
            if(num == 0) {
                zero1++
            }
            sum1 += num
        }

        nums2.forEach { num ->
            if(num == 0) {
                zero2++
            }
            sum2 += num
        }

        if(sum1 > sum2) {
            if(zero2 == 0L) return -1L

            if(zero1 == 0L && sum2 + zero2 > sum1) return -1L

            return max(sum1 + zero1, sum2 + zero2)
        } else if(sum2 > sum1) {
            if(zero1 == 0L) return -1L

            if(zero2 == 0L && sum1 + zero1 > sum2) return -1L

            return max(sum1 + zero1, sum2 + zero2)
        } else {
            if(zero1 == zero2) return sum1 + max(zero1, zero2)

            if(zero1 == 0L || zero2 == 0L) return -1L

            return sum1 + max(zero1, zero2)
        }
    }
}
