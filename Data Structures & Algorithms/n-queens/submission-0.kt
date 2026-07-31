class Solution {
    fun solveNQueens(n: Int): List<List<String>> {

        var output = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        fun isSafe(r: Int, c: Int): Boolean {
            var row = r - 1
            while (row >= 0) {
                if (board[row][c] == 'Q') return false
                row--
            }
            var col = c - 1
            row = r - 1
            while (row >= 0 && col >= 0) {
                if (board[row][col] == 'Q') return false
                row--
                col--
            }
            col = c + 1
            row = r - 1
            while (row >= 0 && col < n) {
                if (board[row][col] == 'Q') return false
                row--
                col++
            }
            return true
        }

        fun dfs(r: Int) {
            if (r == n) {
                output.add(board.map { it.joinToString("") })
                return
            }
            for (c in 0 until n) {
                if (isSafe(r, c)) {
                    board[r][c] = 'Q'
                    dfs(r + 1)
                    board[r][c] = '.'
                }
            }
        }

        dfs(0)

        return output
    }
}
