class Solution {
    fun trap(height: IntArray): Int {
        var leftMax = IntArray(height.count()) { 0 }
        var rightMax = IntArray(height.count()) { 0 }
        var currentMax = height[0]
        for (i in 1 until height.count()) {
            leftMax[i] = currentMax
            currentMax = maxOf(currentMax, height[i])
        }
        currentMax = height[height.count() - 1]
        for (i in height.count() - 2 downTo 0) {
            rightMax[i] = currentMax
            currentMax = maxOf(currentMax, height[i])
        }
        var volume = 0
        for (i in 0 until height.count()) {
            volume += maxOf(minOf(leftMax[i], rightMax[i]) - height[i], 0)
        }
        return volume
    }
}
