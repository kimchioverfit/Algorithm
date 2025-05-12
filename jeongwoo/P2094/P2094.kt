class Solution {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val n = digits.size

        val evenSet = mutableSetOf<Int>()
        for(i in 0 until n) {
            for(j in 0 until n) {
                for(k in 0 until n) {
                    if(i != j && j != k && k != i) {
                        val number = digits[i] * 100 + digits[j] * 10 + digits[k]

                        if(number % 2 == 0 && number / 100 > 0) {
                            evenSet.add(number)
                        }
                    }
                }
            }
        }

        return evenSet.toList().sorted().toIntArray()
    }
}
