class Solution {
    func lengthOfLIS(_ nums: [Int]) -> Int {

        var lis = Array(repeating: 1, count: nums.count)

        for i in stride(from: nums.count - 2, through: 0, by: -1) {
            
            for j in i + 1 ..< nums.count {
                if nums[i] < nums[j] {
                    lis[i] = max(lis[i], 1 + lis[j])
                }
            }
        }

        return lis.max() ?? 0

    }
}