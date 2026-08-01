class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        val ROW = heights.count()
        val COL = heights[0].count()

        var directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        var pac = Array(ROW) { BooleanArray(COL) { false }}
        var atl = Array(ROW) { BooleanArray(COL) { false }}

        var sourcePac = mutableListOf<IntArray>()
        var sourceAtl = mutableListOf<IntArray>()

        for (r in 0 until ROW) {
            sourcePac.add(intArrayOf(r, 0))
            sourceAtl.add(intArrayOf(r, COL - 1))
        }

        for (c in 0 until COL) {
            sourcePac.add(intArrayOf(0, c))
            sourceAtl.add(intArrayOf(ROW - 1, c))
        }

        fun bfs(source: MutableList<IntArray>, ocean: Array<BooleanArray>) {
            var queue = LinkedList<IntArray>()
            queue.addAll(source)
            while (queue.count() > 0) {
                var current = queue.removeFirst()
                var x = current[0]
                var y = current[1]
                ocean[x][y] = true
                for (direction in directions) {
                    var newX = x + direction[0]
                    var newY = y + direction[1]
                    if (newX in 0 until ROW && newY in 0 until COL && ocean[newX][newY] == false) {
                        if (heights[newX][newY] >= heights[x][y]) {
                            queue.add(intArrayOf(newX, newY))
                        }
                    }
                }
            }
        }

        bfs(sourcePac, pac)
        bfs(sourceAtl, atl)

        var result = mutableListOf<List<Int>>()
        for (r in 0 until ROW) {
            for (c in 0 until COL) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }
}
