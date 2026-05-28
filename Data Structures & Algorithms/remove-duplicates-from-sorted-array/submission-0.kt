class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 0
        while (right < nums.count()) {
            if (nums[right] != nums[left]) {
                left += 1
                nums[left] = nums[right]
            }
            right += 1
        }
        return left + 1
    }
}
