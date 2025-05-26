class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val n = dominoes.size
        var answer = 0

        for(i in 0 until n) {
            for(j in (i + 1) until n) {
                if((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                    answer++
                }
            }
        }

        return answer
    }
}
