class Solution {
    func findMin(_ nums: [Int]) -> Int {

        if nums[0] <= nums[nums.count - 1] {
            return nums[0]
        }

        var left = 0
        var right = nums.count - 1

        var output = Int.max

        while left <= right {

            if nums[left] < nums[right] {
                output = min(output, nums[left])
                break
            }

            let mid = (left + right) / 2
            output = min(output, nums[mid])
            if nums[left] <= nums[mid] {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return output

    }
}
