class Solution {
    func productExceptSelf(_ nums: [Int]) -> [Int] {

        var prefix = Array(repeating: 1, count: nums.count)
        var suffix = Array(repeating: 1, count: nums.count)

        var current = 1
        for i in 0 ..< nums.count {
            prefix[i] = current
            current *= nums[i]
        }

        current = 1
        for i in (0 ..< nums.count).reversed() {
            suffix[i] = current
            current *= nums[i]
        }

        var output = Array(repeating: 1, count: nums.count)
        for i in 0 ..< nums.count {
            output[i] = suffix[i] * prefix[i]
        }

        return output

    }
}
