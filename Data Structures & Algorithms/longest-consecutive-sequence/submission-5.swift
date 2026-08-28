class Solution {
    func longestConsecutive(_ nums: [Int]) -> Int {
        if nums.isEmpty { return 0 }
        var hash = Set<Int>()
        for num in nums {
            hash.insert(num)
        }
        var i = 0
        var output = 1
        while i < nums.count {
            var current = nums[i]
            if hash.contains(current - 1) {
                i += 1
                continue
            }
            var length = 1
            while hash.contains(current + 1) {
                current = current + 1
                length += 1
                output = max(output, length)
            }
            i += 1
        }
        return output

    }
}
