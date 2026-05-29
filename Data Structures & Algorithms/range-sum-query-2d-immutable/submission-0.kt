class NumMatrix(matrix: Array<IntArray>) {

    var prefix: Array<IntArray>

    init {
        val ROW = matrix.count()
        val COL = matrix[0].count()

        prefix = Array(ROW) {
            IntArray(COL) {
                0
            }
        }
        for (i in 0 until ROW) {
            var sum = 0
            for (j in 0 until COL) {
                sum += matrix[i][j]
                if (i > 0) {
                    prefix[i][j] = sum + prefix[i - 1][j]
                } else {
                    prefix[i][j] = sum
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var bottomRight = prefix[row2][col2]
        var topRight = if (row1 > 0) { prefix[row1 - 1][col2] } else { 0 }
        var bottomLeft = if (col1 > 0) { prefix[row2][col1 - 1] } else { 0 }
        var topLeft = if (row1 > 0 && col1 > 0) { prefix[row1 - 1][col1 - 1] } else { 0 }
        return bottomRight - topRight - bottomLeft + topLeft
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
