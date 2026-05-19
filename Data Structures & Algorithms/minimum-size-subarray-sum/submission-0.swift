class Solution {
    func minSubArrayLen(_ target: Int, _ nums: [Int]) -> Int {
        var left = 0
        var right = 0
        var currentSum = 0
        var output = Int.max
        while right < nums.count {
            currentSum += nums[right]
            while currentSum >= target {
                output = min(output, right - left + 1)
                currentSum -= nums[left]
                left += 1
            }
            right += 1
        }
        return output == Int.max ? 0 : output
    }
}
