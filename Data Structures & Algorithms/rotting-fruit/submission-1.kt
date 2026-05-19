class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        var queue = mutableListOf<IntArray>()

        for (i in 0 ..< grid.count()) {
            for (j in 0 ..< grid[0].count()) {
                if (grid[i][j] == 2) {
                    queue.add(intArrayOf(i, j, 0))
                }
            }
        }

        var minute = Int.MIN_VALUE

        while (queue.count() > 0) {
            val size = queue.count()
            for (i in 0 ..< size) {
                val current = queue.removeFirst()
                minute = maxOf(minute, current[2])
                for (direction in directions) {
                    var x = current[0] + direction[0]
                    var y = current[1] + direction[1]
                    if (x < 0 || y < 0 || x >= grid.count() || y >= grid[0].count() || grid[x][y] != 1) {
                        continue
                    }
                    grid[x][y] = 2
                    queue.add(intArrayOf(x, y, current[2] + 1))
                }
            }
        }

        for (i in 0 ..< grid.count()) {
            for (j in 0 ..< grid[0].count()) {
                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }

        return if (minute == Int.MIN_VALUE) 0 else minute

    }
}
