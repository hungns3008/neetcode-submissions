class Solution {
    func firstMissingPositive(_ nums: inout [Int]) -> Int {
        var hash = Set<Int>()
        var maxNum = nums[0]
        for num in nums {
            hash.insert(num)
            maxNum = max(maxNum, num)
        }
        maxNum = max(maxNum, 1)
        for i in 1 ... maxNum + 1 {
            if !hash.contains(i) {
                return i
            }
        }
        return -1
    }
}
