class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val count = IntArray(51)

        for (i in 0 until k) {
            count[nums[i]] += 1
        }

        val answer = mutableListOf<Int>()
        for (i in 0..(nums.size - k)) {
            var sum = 0

            val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
                if (a.second == b.second) b.first - a.first else b.second - a.second
            }

            for (j in 1..50) {
                pq.offer(Pair(j, count[j]))
            }

            for (j in 0 until x) {
                val (num, countOfNum) = pq.poll()

                sum += num * countOfNum
            }

            if (k + i < nums.size) {
                count[nums[i]] -= 1
                count[nums[k + i]] += 1
            }

            answer.add(sum)
        }

        return answer.toIntArray()
    }
}