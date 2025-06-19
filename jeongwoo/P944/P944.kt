class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs.size
        val m = strs[0].length

        val array = Array(m) { Array(n) { 'a' } }
        for(i in 0 until m) {
            for(j in 0 until n) {
                array[i][j] = strs[j][i]
            }
        }

        var answer = 0

        for(i in 0 until m) {
            for(j in 1 until n) {
                if(array[i][j] < array[i][j - 1]) {
                    answer++
                    break
                }
            }
        }

        return answer
    }
}
