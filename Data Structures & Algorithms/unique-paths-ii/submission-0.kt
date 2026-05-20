class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

        val m = obstacleGrid.count()
        val n = obstacleGrid[0].count()

        var prev = Array(n) { 0 }

        for (i in n - 1 downTo 0) {
            if (obstacleGrid[m - 1][i] != 1) {
                prev[i] = 1
            } else {
                break
            }                             
        }

        val row = Array(m) { 0 }
        for (i in m - 1 downTo 0) {
            if (obstacleGrid[i][n - 1] != 1) {
                row[i] = 1
            } else {
                break
            }
        }
        
        for (r in m - 2 downTo 0) {
            val current = Array(n) { 0 }
            if (row[r] == 1) {
                current[current.lastIndex] = 1
            }
            for (c in n - 2 downTo 0) {
                if (obstacleGrid[r][c] == 1) {
                    current[c] = 0
                } else {
                    current[c] = current[c + 1] + prev[c]
                }
            }
            prev = current
        }

        return prev[0]

    }
}
