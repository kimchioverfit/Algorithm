class Solution {
    fun clearDigits(s: String): String {
        val n = s.length
        var digitCount = 0
        val answer = StringBuilder()

        for(i in (n - 1) downTo 0) {
            if(s[i] in '0'..'9') {
                digitCount += 1
            } else {
                if(digitCount >= 1) {
                    digitCount -= 1
                } else {
                    answer.append(s[i])
                }
            }
        }

        return answer.reverse().toString()
    }
}