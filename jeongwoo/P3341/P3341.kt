class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size

        val moves = listOf(listOf(0, 1), listOf(0, -1), listOf(1, 0), listOf(-1, 0))

        // (y, x, time)
        val pq = PriorityQueue<Triple<Int, Int, Int>>( { a, b -> a.third - b.third } )

        pq.offer(Triple(0, 0, 0))

        val times = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        times[0][0] = 0

        while(!pq.isEmpty()) {
            val cur = pq.poll()

            for(move in moves) {
                val nx = cur.second + move[0]
                val ny = cur.first + move[1]

                if((nx in 0..(m - 1)) && (ny in 0..(n - 1))) {
                    if(cur.third + 1 < times[ny][nx]) {
                        times[ny][nx] = if(cur.third < moveTime[ny][nx]) moveTime[ny][nx] + 1 
                                        else cur.third + 1

                        pq.offer(Triple(ny, nx, times[ny][nx]))
                    }
                }
            }
        }
        return times[n - 1][m - 1]
    }
}
