class Solution {
    func maxSubArray(_ nums: [Int]) -> Int {

        var current = 0
        var output = Int.min

        for num in nums {
            current += num
            output = max(output, current)
            current = max(current, 0)
        }

        return output

    }
}
