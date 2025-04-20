class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val connections = Array(n) { BooleanArray(n) }

        val distances = IntArray(n)
        for(i in 1 until n) {
            distances[i] = i
            connections[i][i - 1] = true
        }

        val answer = IntArray(queries.size)
        var idx = 0

        for(query in queries) {
            val x = query[0]
            val y = query[1]

            connections[y][x] = true
            distances[y] = min(distances[y], distances[x] + 1)

            for(i in y until n) {
                for(j in 0 until i) {
                    if(connections[i][j]) {
                        distances[i] = min(distances[i], distances[j] + 1)
                    }
                }
            }

            answer[idx++] = distances[n - 1]
        }
        
        return answer
    }
}
