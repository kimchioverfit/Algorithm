class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        var idx = -1

        for(i in 0 until word.length) {
            if(word[i] == ch) {
                idx = i
                break
            }
        }

        if(idx == -1) return word

        val reversedPrefix = StringBuilder(word.substring(0, idx + 1)).reverse().toString()

        return "$reversedPrefix${word.substring(idx + 1, word.length)}"
    }
}