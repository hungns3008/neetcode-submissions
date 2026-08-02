class Solution {
    fun canJump(nums: IntArray): Boolean {

        var goal = nums.lastIndex

        for (i in nums.lastIndex - 1 downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }

        return goal == 0

    }
}
