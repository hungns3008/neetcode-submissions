class Solution {
    fun maxProduct(nums: IntArray): Int {
        
        var res = nums[0]
        var curMin = 1
        var curMax = 1
        for (num in nums) {
            val tmp = curMax * num
            curMax = maxOf(num * curMax, num * curMin, num)
            curMin = minOf(tmp, num * curMin, num)
            res = maxOf(res, curMax)
        }
        return res

    }
}
