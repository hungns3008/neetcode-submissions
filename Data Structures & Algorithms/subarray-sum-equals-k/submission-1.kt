class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        var count = 0

        for (i in 0 until nums.count()) {
            var sum = nums[i]
            if (sum == k) {
                count += 1
            }
            for (j in i + 1 until nums.count()) {
                sum += nums[j]
                if (sum == k) {
                    count += 1
                }
            }
        }

        return count

    }
}
