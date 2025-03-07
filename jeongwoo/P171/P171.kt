class Solution {
    fun titleToNumber(columnTitle: String): Int {
        val length = columnTitle.length
        var answer = 0
        var mul = 1

        for(i in length - 1 downTo 0) {
            answer += mul * (columnTitle[i] - 'A' + 1)

            mul *= 26
        }

        return answer
    }
}