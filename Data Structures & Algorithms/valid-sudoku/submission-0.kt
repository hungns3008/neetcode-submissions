class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val ROW = board.count()
        var COL = board[0].count()

        fun isValidRow(r: Int): Boolean {
            var hash = mutableSetOf<Char>()
            for (c in 0 until COL) {
                var current = board[r][c]
                if (current != '.') {
                    if (hash.contains(current)) {
                        return false
                    }
                    hash.add(current)
                }
            }
            return true
        }

        fun isValidCol(c: Int): Boolean {
            var hash = mutableSetOf<Char>()
            for (r in 0 until ROW) {
                var current = board[r][c]
                if (current != '.') {
                    if (hash.contains(current)) {
                        return false
                    }
                    hash.add(current)
                }
            }
            return true
        }

        fun isValidBox(r: Int, c: Int): Boolean {
            var startingRow = r / 3
            var startingCol = c / 3
            var hash = mutableSetOf<Char>()
            for (i in startingRow * 3 until startingRow * 3 + 3) {
                for (j in startingCol * 3 until startingCol * 3 + 3) {
                    var current = board[i][j]
                    if (current != '.') {
                        if (hash.contains(current)) {
                            return false
                        }
                        hash.add(current)
                    }
                }
            }
            return true
        }

        for (r in 0 until ROW) {
            if (!isValidRow(r)) {
                return false
            }
            for (c in 0 until COL) {
                if (!isValidCol(c)) {
                    return false
                }
                if (!isValidBox(r, c)) {
                    return false
                }
            }
        }
        return true

    }
}
