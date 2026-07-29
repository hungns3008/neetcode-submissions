class Solution {
    fun trap(height: IntArray): Int {
        var leftMax = height[0]
        var rightMax = height[height.count() - 1]
        var left = 1
        var right = height.count() - 2
        var water = 0
        while (left <= right) {
            if (leftMax <= rightMax) {
                water += maxOf(minOf(leftMax, rightMax) - height[left], 0)
                leftMax = maxOf(leftMax, height[left])
                left += 1
            } else {
                water += maxOf(minOf(leftMax, rightMax) - height[right], 0)
                rightMax = maxOf(rightMax, height[right])
                right -= 1
            }
        }
        return water
    }
}
