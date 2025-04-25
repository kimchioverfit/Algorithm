class Solution {
    fun getLucky(s: String, k: Int): Int {
        val sb = StringBuilder()

        for(ch in s) {
            sb.append(ch - 'a' + 1)
        }

        var sum = 0
        for(i in 0 until k) {
            val transform = sb.toString()
            
            sum = 0
            sb.clear()

            for(ch in transform) {
                sum += ch - '0'
            }

            sb.append(sum)
        }

        return sum
    }
}
