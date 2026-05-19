class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        var candidate = 0
        var counter = 0
        for i in 0 ..< nums.count {
            if counter == 0 {
                candidate = nums[i]
                counter += 1
            } else if nums[i] == candidate {
                counter += 1
            } else {
                counter -= 1
            }
        }
        return candidate
    }
}
