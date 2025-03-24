class Solution {
    fun countCompleteDayPairs(hours: IntArray): Int {
        val n = hours.size

        var answer = 0

        for(i in 0 until n) {
            for(j in (i + 1) until n) {
                if((hours[i] + hours[j]) % 24 == 0) {
                    answer += 1
                }
            }
        }

        return answer
    }
}
