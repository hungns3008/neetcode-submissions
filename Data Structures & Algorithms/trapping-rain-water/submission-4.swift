class Solution {
    func trap(_ height: [Int]) -> Int {
        if height.isEmpty { return 0 }
        var maxLeft = height[0]
        var maxRight = height[height.count - 1]

        var left = 1
        var right = height.count - 2

        var output = 0

        while left <= right {
            if maxLeft < maxRight {
                maxLeft = max(maxLeft, height[left])
                output += maxLeft - height[left]
                left += 1
            } else {
                maxRight = max(maxRight, height[right])
                output += maxRight - height[right]
                right -= 1
            }
        }

        return output

    }
}
