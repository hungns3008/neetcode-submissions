class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        var path = mutableSetOf<String>()

        fun dfs(i: Int, x: Int, y: Int): Boolean {
            if (x < 0 || x >= board.count() || y < 0 || y >= board[0].count() || path.contains("${x}-${y}") || board[x][y] != word[i]) {
                return false
            }
            if (i == word.count() - 1) {
                return true
            }
            path.add("${x}-${y}")
            var found = dfs(i + 1, x + 1, y) || dfs(i + 1,x, y + 1) || dfs(i + 1, x - 1, y) || dfs(i + 1, x, y - 1)
            path.remove("${x}-${y}")
            return found

        }
        
        for (i in 0 until board.count()) {
            for (j in 0 until board[0].count()) {
                if (dfs(0, i, j)) {
                    return true
                }
            }
        }

        return false

    }
}