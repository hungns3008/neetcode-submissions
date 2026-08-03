class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var colZero = IntArray(matrix[0].count()) { 1 }
        var rowZero = IntArray(matrix.count()) { 1 }

        for (r in 0 until matrix.count()) {
            for (c in 0 until matrix[0].count()) {
                if (matrix[r][c] == 0) {
                    rowZero[r] = 0
                    colZero[c] = 0
                }
            }
        }

        for (r in 0 until matrix.count()) {
            for (c in 0 until matrix[0].count()) {
                if (rowZero[r] == 0 || colZero[c] == 0) {
                    matrix[r][c] = 0
                }
            }
        }

    }
}
