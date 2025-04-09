class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val words = text.split(" ")

        var answer = 0
        for(word in words) {
            var canType = true
            for(letter in brokenLetters) {
                if(word.contains(letter)) {
                    canType = false
                    break
                }
            }

            if(canType) answer++
        }

        return answer
    }
}
