class Solution {
    func sortColors(_ nums: inout [Int]) {
        
        var left = 0
        var right = nums.count - 1
        var i = 0

        while i <= right {
            if nums[i] == 0 {
                swap(&nums, left, i)
                left += 1
                i += 1
            } else if nums[i] == 2 {
                swap(&nums, right, i)
                right -= 1
            } else {
                i += 1
            }
        }

    }

    func swap(_ nums: inout [Int], _ i: Int, _ j: Int) {
        let temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
