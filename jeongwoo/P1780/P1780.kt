class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        if(n == 1) return true

        var sumSet = mutableSetOf<Int>()

        sumSet.add(0)
        sumSet.add(1)

        var num = 1
        for(i in 0 until 14) {
            val temp = mutableSetOf<Int>()

            num *= 3

            sumSet.forEach { sum ->
                temp.add(sum)
                
                temp.add(sum + num)
            }

            sumSet = temp
            
            if(sumSet.contains(n)) return true
        }

        return false
    }
}
