class Solution {
    fun maxProduct(nums: IntArray): Int {
        val sorted = nums.sorted()
        val size = nums.size

        return (sorted[size - 2] - 1) * (sorted[size - 1] - 1)
    }
}
