class Solution {
    fun trap(height: IntArray): Int {
        var left = IntArray(height.count()) { 0 }
        var right = IntArray(height.count()) { 0 }
        var currentMax = height[0]
        for (i in 1 until height.count()) {
            left[i] = currentMax
            currentMax = maxOf(currentMax, height[i])
        }
        currentMax = height[height.count() - 1]
        for (i in height.count() - 2 downTo 0) {
            right[i] = currentMax
            currentMax = maxOf(currentMax, height[i])
        }
        var water = 0
        for (i in 0 until height.count()) {
            water += maxOf(0, minOf(left[i], right[i]) - height[i])
        }
        return water
    }
}
