class Solution {
    fun maxSubArray(nums: IntArray): Int {

        var currentSum = 0
        var output = Int.MIN_VALUE

        for (num in nums) {
            currentSum += num
            output = maxOf(output, currentSum)
            currentSum = maxOf(0, currentSum)
        }

        return output

    }
}
