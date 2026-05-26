class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        var numSets = mutableSetOf<Int>()
        var left = 0
        var right = 0
        while (right < nums.count()) {
            while (right - left > k) {
                numSets.remove(nums[left])
                left += 1
            }
            if (numSets.contains(nums[right])) {
                return true
            }
            numSets.add(nums[right])
            right += 1
        }
        return false
    }
}
