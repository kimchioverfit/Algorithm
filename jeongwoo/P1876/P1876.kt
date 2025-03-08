class Solution {
    fun countGoodSubstrings(s: String): Int {
        var answer = 0

        for(i in 0 until s.length - 2) {
            if((s[i] != s[i + 1]) && (s[i] != s[i + 2]) && (s[i + 1] != s[i + 2])) {
                answer += 1
            }
        }

        return answer
    }
}