class Solution {
    fun differenceOfSums(n: Int, m: Int): Int {
        var num1 = 0
        var sum = 0

        for(i in 1..n) {
            if(i % m != 0) num1 += i

            sum += i
        }

        return num1 - (sum - num1)
    }
}
