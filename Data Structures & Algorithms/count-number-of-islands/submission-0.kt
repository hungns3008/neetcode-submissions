class Solution {
    fun numIslands(grid: Array<CharArray>): Int {

        var directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun dfs(i: Int, j: Int) {
            grid[i][j] = '2'
            for (direction in directions) {
                var nI = i + direction[0]
                var nJ = j + direction[1]
                if (nI >= 0 && nI < grid.count() && nJ >= 0 && nJ < grid[0].count() && grid[nI][nJ] == '1') {
                    dfs(nI, nJ)
                }
            }
        }

        var counter = 0
        for (i in 0 ..< grid.count()) {
            for (j in 0 ..< grid[i].count()) {
                if (grid[i][j] == '1') {
                    counter += 1
                    dfs(i, j)
                }
            }
        }
        return counter
    }
}
