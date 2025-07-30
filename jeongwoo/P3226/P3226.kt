class Solution {
    fun toBinary(number: Int): String {
        var n = number
        val sb = StringBuilder()

        while(n > 0) {
            sb.append(n % 2)
            n /= 2
        }

        return sb.toString()
    }

    fun minChanges(n: Int, k: Int): Int {
        val s1 = toBinary(n)
        val s2 = toBinary(k).padEnd(s1.length, '0')

        if(s1.length < s2.length) return -1

        var answer = 0

        for(i in 0 until s1.length) {
            if(s1[i] != s2[i]) {
                if(s1[i] == '1') answer++
                else return -1
            }
        }

        return answer
    }
}
