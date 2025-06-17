class Solution {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        var answer = 0
        val pq = PriorityQueue<Pair<Int, Int>> () { a, b -> a.second - b.second }

        val n = apples.size
        var day = 0

        for(i in 0 until n) {
            if(apples[i] > 0) {
                pq.offer(Pair(apples[i], i + days[i] - 1))
            }

            day++

            if(pq.isEmpty()) continue

            if(pq.peek().second < i) {
                while(!pq.isEmpty()) {
                    val t = pq.peek()

                    if(t.second < i) pq.poll()
                    else break
                }
            }

            if(pq.isEmpty()) continue

            answer++

            val top = pq.poll()
            if(top.first > 1 && top.second > i) {
                pq.offer(Pair(top.first - 1, top.second))
            }
        }

        while(!pq.isEmpty()) {
            if(pq.peek().second < day) {
                while(!pq.isEmpty()) {
                    val t = pq.peek()

                    if(t.second < day) pq.poll()
                    else break
                }
            }

            if(pq.isEmpty()) break

            val top = pq.poll()
            if(top.first > 1 && top.second > day) {
                pq.offer(Pair(top.first - 1, top.second))
            }
            answer++

            day++
        }

        return answer
    }
}
