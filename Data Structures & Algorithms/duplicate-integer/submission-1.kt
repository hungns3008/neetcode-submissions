class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        var sets = mutableSetOf<Int>()
        for (num in nums) {
            if (sets.contains(num)) {
                return true
            }
            sets.add(num)
        }
        return false
    }
}
