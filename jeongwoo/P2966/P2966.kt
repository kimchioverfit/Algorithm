class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val sorted = nums.sorted()

        val n = nums.size
        val answer = mutableListOf<IntArray>()

        for(i in 0 until n / 3) {
            val first = sorted[i * 3]
            val second = sorted[i * 3 + 1]
            val third = sorted[i * 3 + 2]

            if(second - first <= k && third - second <= k && third - first <= k) {
                answer.add(intArrayOf(first, second, third))
            } else {
                return arrayOf<IntArray>()
            }
        }

        return answer.toTypedArray()
    }
}
