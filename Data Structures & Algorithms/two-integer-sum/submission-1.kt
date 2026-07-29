class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var hash = HashMap<Int, Int>()
        for (i in 0 until nums.count()) {
            if (hash[nums[i]] != null) {
                return intArrayOf(hash[nums[i]]!!, i)
            }
            hash[target - nums[i]] = i
        }
        return intArrayOf()
    }
}
