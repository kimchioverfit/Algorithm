class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val replaced = paragraph.replace("[!?',;.]".toRegex(), " ").split(" ")

        val wordMap = mutableMapOf<String, Int>()

        replaced.forEach { word ->
            if(word.isNotEmpty())
                wordMap[word.lowercase()] = wordMap.getOrDefault(word.lowercase(), 0) + 1
        }

        val sorted = wordMap.toList().sortedByDescending { it.second }

        for(word in sorted) {
            if(!banned.contains(word.first)) return word.first
        }

        return ""
    }
}
