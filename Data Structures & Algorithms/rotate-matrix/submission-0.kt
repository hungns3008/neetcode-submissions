class Solution {
    fun rotate(matrix: Array<IntArray>) {

        var hash = mutableSetOf<String>()

        for (r in 0 until matrix.count()) {
            for (c in 0 until matrix[0].count()) {
                if (!hash.contains("$r $c")) {
                    hash.add("$r $c")
                    hash.add("$c $r")
                    val temp = matrix[r][c]
                    matrix[r][c] = matrix[c][r]
                    matrix[c][r] = temp
                }
            }
        }

        for (r in 0 until matrix.count()) {
            for (c in 0 until matrix[0].count() / 2) {
                val temp = matrix[r][c]
                matrix[r][c] = matrix[r][matrix[0].count() - c - 1]
                matrix[r][matrix[0].count() - c - 1] = temp
            }
        }

    }
}
