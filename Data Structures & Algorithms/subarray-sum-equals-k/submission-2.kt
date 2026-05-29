class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        var map = HashMap<Int, Int>()
        map[0] = 1
        var output = 0
        var sum = 0
        for (i in 0 until nums.count()) {
            sum += nums[i]
            if (map[sum - k] != null) {
                output += map[sum - k]!!
            }
            map[sum] = (map[sum] ?: 0) + 1
        }
        return output
    }
}
