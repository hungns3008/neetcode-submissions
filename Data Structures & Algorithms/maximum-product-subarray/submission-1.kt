class Solution {
    fun maxProduct(nums: IntArray): Int {
        
        var res = nums[0]
        var currentMin = 1
        var currentMax = 1
        for (num in nums) {
            val temp = currentMax * num
            currentMax = maxOf(currentMax * num, currentMin * num, num)
            currentMin = minOf(currentMin * num, temp, num)
            res = maxOf(res, currentMax)
        }
        return res

    }
}
