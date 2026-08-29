class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {

        let COL = matrix[0].count - 1

        var top = 0
        var bottom = matrix.count - 1

        var targetRow = -1

        while top <= bottom {
            let mid = (top + bottom) / 2
            if matrix[mid][0] > target {
                bottom = mid - 1
            } else if matrix[mid][COL] < target {
                top = mid + 1
            } else {
                targetRow = mid
                break
            }
        }

        if targetRow == -1 {
            return false
        }

        var left = 0
        var right = COL
        while left <= right {
            let mid = (left + right) / 2
            if matrix[targetRow][mid] == target {
                return true
            } else if matrix[targetRow][mid] < target {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false

    }
}
