class Solution {
    fun getSmallestString(_n: Int, _k: Int): String {
        var n = _n
        var k = _k

        val sb = StringBuilder()

        while(n > 0) {
            if(n == k) {
                sb.append("a".repeat(n))

                n = 0
                k = 0
            } else {
                if(k - n >= 26) {
                    sb.append("z")
                    k -= 26
                } else {
                    sb.append(('a' + (k - n)))
                    k = k - (k - n + 1)
                }

                n -= 1
            }
        }

        return sb.reverse().toString()
    }
}