class Solution {
    fun rob(nums: IntArray): Int {

        if (nums.count() < 0) {
            return -1
        }

        if (nums.count() == 1) {
            return nums[0]
        }

        var cache = Array(nums.count()) { 0 }
        cache[0] = nums[0]
        cache[1] = maxOf(cache[0], nums[1])

        for (i in 2 ..< nums.count()) {
            cache[i] = maxOf(nums[i] + cache[i - 2], cache[i - 1])
        }

        return cache[cache.lastIndex]

    }
}
