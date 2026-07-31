class Solution {
    fun solveNQueens(n: Int): List<List<String>> {

        var output = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        var posDia = HashSet<Int>()
        var nevDia = HashSet<Int>()
        var col = HashSet<Int>()

        fun backtrack(r: Int) {
            if (r == n) {
                output.add(board.map { it.joinToString("") })
                return
            }
            for (c in 0 until n) {
                if (c in col || (r + c) in posDia || (r - c) in nevDia) {
                    continue
                }
                col.add(c)
                posDia.add(r + c)
                nevDia.add(r - c)
                board[r][c] = 'Q'

                backtrack(r + 1)

                col.remove(c)
                posDia.remove(r + c)
                nevDia.remove(r - c)
                board[r][c] = '.'
            }
        }

        backtrack(0)

        return output
    }
}
