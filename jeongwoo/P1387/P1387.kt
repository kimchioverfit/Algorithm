class Solution {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val powers = mutableMapOf<Int, Int>()

        powers[1] = 0

        for(num in lo..hi) {
            val stack = Stack<Int>()
            stack.push(num)

            while(true) {
                val top = stack.peek()

                if(powers[top] != null || top == 1) {
                    stack.pop()
                    var power = powers[top]!!
                    
                    while(!stack.isEmpty()) {
                        val cur = stack.pop()
                        powers[cur] = power + 1

                        power++
                    }

                    break
                }

                if(top % 2 == 1) stack.push(top * 3 + 1)
                else stack.push(top / 2)
            }
        }
        
        val numbers = (lo..hi).toList()
            .sortedWith(compareBy({ powers[it]}, { it }))
        
        return numbers[k - 1]
    }
}
