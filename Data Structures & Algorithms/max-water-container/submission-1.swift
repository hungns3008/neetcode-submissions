class Solution {
    func maxArea(_ heights: [Int]) -> Int {
        var left = 0
        var right = heights.count - 1
        var output = 0
        while left < right {
            output = max(output, (right - left) * min(heights[left], heights[right]))
            if heights[left] < heights[right] {
                left += 1
            } else {
                right -= 1
            }
        }
        return output
    }
}
