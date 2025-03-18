class Solution {
    fun smallestNumber(num: Long): Long {
        if(num == 0L) return 0L

        val isPositive = num > 0

        val numbers = "${if(isPositive) num else num * -1}"
        val count = IntArray(10)
        for(n in numbers) {
            count[n - '0'] += 1
        }

        val answer = StringBuilder()
        if(!isPositive) answer.append('-')

        var startNumber = 0
        if(isPositive) {
            for(i in 1..9) {
                if(count[i] >= 1) {
                    startNumber = i
                    count[i] -= 1
                    break
                }
            }
        } else {
            for(i in 9 downTo 1) {
                if(count[i] >= 1) {
                    startNumber = i
                    count[i] -= 1
                    break
                }
            }
        }
        answer.append(startNumber)

        if(isPositive) {
            for(i in 0..9) {
                if(count[i] >= 1) {
                    answer.append("$i".repeat(count[i]))
                }
            }
        } else {
            for(i in 9 downTo 0) {
                if(count[i] >= 1) {
                    answer.append("$i".repeat(count[i]))
                }
            }
        }

        return answer.toString().toLong()
    }
}
