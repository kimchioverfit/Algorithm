class Solution {
    fun getEncryptedString(s: String, k: Int): String {
        var answer = ""

        for(i in s.indices) {
            answer += s[(i + k) % s.length]
        }

        return answer
    }
}