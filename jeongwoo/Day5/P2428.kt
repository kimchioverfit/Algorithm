class Solution {
    fun maxSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var answer = 0
        for(i in 0 until m - 2) {
            for(j in 0 until n - 2) {
                val sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]

                if(sum > answer) {
                    answer = sum
                }
            }
        }

        return answer
    }
}