class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

        if (grid[0][0] == 1) {
            return -1
        }

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
            intArrayOf(1, 1),
            intArrayOf(-1, -1),
            intArrayOf(1, -1),
            intArrayOf(-1, 1)
        )

        var stack = mutableListOf<IntArray>()
        var visited = mutableSetOf<String>()
        stack.add(intArrayOf(0, 0, 1))
        visited.add("${0}-${0}")

        while (stack.count() > 0) {
            val size = stack.count()
            for (i in 0 ..< size) {
                val cell = stack.removeFirst()
                if (cell[0] == grid.count() - 1 && cell[1] == grid[0].count() - 1) {
                    return cell[2]
                }
                for (direction in directions) {
                    val r = cell[0] + direction[0]
                    val c = cell[1] + direction[1]
                    if (r >= 0 && c >= 0 && r < grid.count() && c < grid[0].count() && !visited.contains("${r}-${c}") && grid[r][c] == 0) {
                        stack.add(intArrayOf(r, c, cell[2] + 1))
                        visited.add("${r}-${c}")
                    }
                }
            }
        }

        return -1

    }
}
