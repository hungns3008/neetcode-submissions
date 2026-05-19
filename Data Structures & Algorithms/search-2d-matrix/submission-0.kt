class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val COL = matrix[0].lastIndex
        var top = 0
        var bottom = matrix.lastIndex
        var targetRow = -1
        while (top <= bottom) {
            var mid = (top + bottom) / 2
            if (matrix[mid][0] <= target && matrix[mid][COL] >= target) {
                targetRow = mid
                break
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1
            } else {
                top = mid + 1
            }
        }
        if (targetRow == -1) {
            return false
        }
        var left = 0
        var right = matrix[0].lastIndex
        while (left <= right) {
            var mid = (left + right) / 2
            if (matrix[targetRow][mid] == target) {
                return true
            } else if (matrix[targetRow][mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}
