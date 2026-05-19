class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun dfs(i: Int, j: Int): Int {
            grid[i][j] = 2
            var area = 1
            for (direction in directions) {
                var nI = i + direction[0]
                var nJ = j + direction[1]
                if (nI >= 0 && nI < grid.count() && nJ >= 0 && nJ < grid[0].count() && grid[nI][nJ] == 1) {
                    area += dfs(nI, nJ)
                }
            }
            return area 
        }

        var max = 0
        for (i in 0 ..< grid.count()) {
            for (j in 0 ..< grid[i].count()) {
                if (grid[i][j] == 1) {
                    max = maxOf(max, dfs(i, j))
                }
            }
        }
        return max
    }
}
