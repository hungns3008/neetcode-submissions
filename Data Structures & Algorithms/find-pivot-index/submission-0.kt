class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var prefix = IntArray(nums.count()) { 0 }
        var sum = 0
        for (i in 0 until nums.count()) {
            sum += nums[i]
            prefix[i] = sum
        }
        for (i in 0 until nums.count()) {
            var leftSum = if (i > 0) { prefix[i - 1] } else { 0 }
            var rightSum = sum - prefix[i]
            if (leftSum == rightSum) {
                return i
            }
        }
        return -1
    }
}
