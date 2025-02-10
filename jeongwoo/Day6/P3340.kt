class Solution {
    fun isBalanced(num: String): Boolean {
        var sum = 0

        for(i in 0 until num.length) {
            val cur = num[i] - '0'

            sum = sum + if(i % 2 == 0) cur else cur * -1
        }

        return sum == 0
    }
}