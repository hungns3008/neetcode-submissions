class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var counter = 0
        var i = 0
        var output = 0
        while (i < nums.count()) {
            if (nums[i] == 1) {
                counter += 1
                output = maxOf(output, counter)
            } else {
                counter = 0
            }
            i += 1
        }
        return output
    }
}
