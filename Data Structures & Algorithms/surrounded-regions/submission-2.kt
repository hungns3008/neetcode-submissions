class Solution {
    fun solve(board: Array<CharArray>) {

        val directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

        val ROW = board.count()
        val COL = board[0].count()

        fun dfs(r: Int, c: Int, region: MutableSet<List<Int>>): Boolean {
            if (board[r][c] == 'X') return true
            if (r == 0 || r == ROW - 1 || c == 0 || c == COL - 1) return false

            region.add(listOf(r, c))
            var isValid = true

            for (direction in directions) {
                val newX = r + direction[0]
                val newY = c + direction[1]
                if (newX in 0 until ROW && newY in 0 until COL && !region.contains(listOf(newX, newY))) {
                    if (!dfs(newX, newY, region)) {
                        isValid = false
                    }
                }
            }
            return isValid
        }

        for (i in 0 until ROW) {
            for (j in 0 until COL) {
                if (board[i][j] == 'O') {
                    val region = mutableSetOf<List<Int>>()
                    if (dfs(i, j, region)) {
                        for (cell in region) {
                            board[cell[0]][cell[1]] = 'X'
                        }
                    }
                }
            }
        }
    }
}