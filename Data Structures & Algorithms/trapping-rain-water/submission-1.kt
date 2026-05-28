class Solution {
    fun trap(height: IntArray): Int {
        var leftMax = height[0]
        var rightMax = height[height.count() - 1]
        var left = 1
        var right = height.count() - 1
        var water = 0
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = maxOf(leftMax, height[left])
                water += leftMax - height[left]
                left += 1
            } else {
                rightMax = maxOf(rightMax, height[right])
                water += rightMax - height[right]
                right -= 1
            }
        }
        return water
    }
}
