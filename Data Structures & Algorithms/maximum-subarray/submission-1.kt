class Solution {
    fun maxSubArray(nums: IntArray): Int {

        var current = 0
        var output = Int.MIN_VALUE

        for (num in nums) {
            if (current < 0) {
                current = num
            } else {
                current += num
            }
            output = maxOf(output, current)
        }
        
        return output

    }
}
