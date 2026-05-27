class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var left = 0
        var right = 0
        var currentSum = 0
        var output = Int.MAX_VALUE

        while (right < nums.count()) {
            currentSum += nums[right]
            while (currentSum >= target) {
                output = minOf(output, right - left + 1)
                currentSum -= nums[left]
                left += 1
            }
            right += 1
        }

        return if (output == Int.MAX_VALUE) { 0 } else { output }

    }
}
