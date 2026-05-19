class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            if (nums[left] != `val`) {
                left += 1
                continue
            }
            while (left < right && nums[right] == `val`) {
                right -= 1
            }
            nums[left] = nums[right]
            right -= 1
        }
        return left
    }
}
