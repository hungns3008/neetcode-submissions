class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 0
        while (right < nums.count()) {
            var count = 1
            while (right + 1 < nums.count() && nums[right] == nums[right + 1]) {
                count += 1
                right += 1
            }
            for (i in 0 until minOf(2, count)) {
                nums[left] = nums[right]
                left += 1
            }
            right += 1
        }
        return left
    }
}