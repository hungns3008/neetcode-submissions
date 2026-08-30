class Solution {
    func maxProduct(_ nums: [Int]) -> Int {

        var res = nums[0]
        var currentMin = 1
        var currentMax = 1
        for num in nums {
            let temp = currentMax * num
            currentMax = max(currentMax * num, currentMin * num, num)
            currentMin = min(currentMin * num, temp, num)
            res = max(res, currentMax)
        }
        return res

    }
}
