class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.count() - 1
        var output = 0
        while (l < r) {
            var left = heights[l]
            var right = heights[r]
            output = maxOf(output, minOf(left, right) * (r - l))
            if (left <= right) {
                l += 1
            } else {
                r -= 1
            }
        }
        return output
    }
}
