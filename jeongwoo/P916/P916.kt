class Solution {
    fun countChar(word: String): IntArray {
        val counts = IntArray(26)

        for(ch in word) {
            counts[ch - 'a']++
        }

        return counts
    }

    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val counts = Array(words2.size) { IntArray(26) }

        for(i in 0 until words2.size) {
            counts[i] = countChar(words2[i])
        }

        val answer = mutableListOf<String>()
        for(word in words1) {
            val wordCount = countChar(word)

            var isUniversal = true

            for(count in counts) {
                if(!isUniversal) break

                for(i in 0 until 26) {
                    if(count[i] > wordCount[i]) {
                        isUniversal = false
                    }
                }
            }

            if(isUniversal) {
                answer.add(word)
            }
        }

        return answer
    }
}