class Solution {
    data class Point(
        val x: Int,
        val y: Int,
        val time: Int,
        val prev: Int
    )

    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size

        val times = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val moves = listOf(listOf(0, 1), listOf(0, -1), listOf(1, 0), listOf(-1, 0))

        // (y, x, time)
        val pq = PriorityQueue<Point>() { a, b -> a.time - b.time }
        pq.offer(Point(0, 0, 0, 2))

        while(!pq.isEmpty()) {
            val (x, y, time, prev) = pq.poll()

            for(move in moves) {
                val ny = y + move[0]
                val nx = x + move[1]
                val nt = if(prev == 1) 2 else 1

                if((nx in 0 until m) && (ny in 0 until n)) {
                    if(times[ny][nx] > time + nt) {
                        times[ny][nx] = if(time < moveTime[ny][nx]) moveTime[ny][nx] + nt
                                            else time + nt

                        pq.offer(Point(nx, ny, times[ny][nx], nt))
                    }
                }
            }
        }

        return times[n - 1][m - 1]
    }
}
