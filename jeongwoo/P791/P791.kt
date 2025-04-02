class Solution {
    fun customSortString(order: String, s: String): String {
        val orderArr = IntArray(26)

        order.mapIndexed { idx, ch ->
            orderArr[ch - 'a'] = idx + 1
        }

        return s.toCharArray()
            .sortedBy { orderArr[it - 'a'] }
            .joinToString("")
    }
}