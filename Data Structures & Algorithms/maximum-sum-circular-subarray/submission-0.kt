class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        var currentMax = 0
        var currentMin = 0
        var total = 0
        for (num in nums) {
            total += num
            currentMax += num
            currentMin += num
            max = maxOf(max, currentMax)
            min = minOf(min, currentMin)
            currentMax = maxOf(0, currentMax)
            currentMin = minOf(0, currentMin)
        }
        if (total < 0) {
            return max
        }
        return maxOf(max, total - min)
    }
}
