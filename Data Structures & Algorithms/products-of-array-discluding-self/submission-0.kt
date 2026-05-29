class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var prefix = IntArray(nums.count()) { 1 }
        var suffix = IntArray(nums.count()) { 1 }

        var current = nums[0]
        for (i in 1 until nums.count()) {
            prefix[i] = current
            current *= nums[i]
        }
        current = nums[nums.count() - 1]
        for (i in nums.count() - 2 downTo 0) {
            suffix[i] = current
            current *= nums[i]
        }
        var output = IntArray(nums.count()) { 1 }
        for (i in 0 until output.count()) {
            output[i] = prefix[i] * suffix[i]
        }
        return output
    }
}
