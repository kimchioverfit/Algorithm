class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val m = board.size
        val n = board[0].size

        val visited = Array(m) { BooleanArray(n) }
        val dirs = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    var hasEdge = false
                    var regions = mutableListOf<Pair<Int, Int>>()
                    var traversal = LinkedList<Pair<Int, Int>>()

                    regions.add(Pair(i, j))
                    traversal.offer(Pair(i, j))
                    visited[i][j] = true

                    while(!traversal.isEmpty()) {
                        val (y, x) = traversal.poll()

                        for(dir in dirs) {
                            val nx = x + dir.first
                            val ny = y + dir.second

                            if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if(board[ny][nx] == 'O' && !visited[ny][nx]) {
                                    regions.add(Pair(ny, nx))
                                    traversal.offer(Pair(ny, nx))

                                    visited[ny][nx] = true
                                }
                            }
                        }

                        if(x == 0 || y == 0 || x == (n - 1) || y == (m - 1)) {
                            hasEdge = true
                        }
                    }

                    if(!hasEdge) {
                        for(region in regions) {
                            val (y, x) = region

                            board[y][x] = 'X'
                        }
                    }
                }
            }
        }
    }
}