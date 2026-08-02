class Solution {
    fun canPartition(nums: IntArray): Boolean {
        var total = 0
        for (num in nums) {
            total += num
        }
        if (total % 2 != 0) {
            return false
        }
        var half = total / 2

        var cache = HashMap<Pair<Int, Int>, Boolean>()

        fun dfs(i: Int, current: Int): Boolean {

            if (current == half) {
                return true
            }

            if (i >= nums.count()) {
                return false
            }

            if (cache[Pair(i, current)] != null) {
                return cache[Pair(i, current)]!!
            }

            cache[Pair(i, current)] = dfs(i + 1, nums[i] + current) || dfs(i + 1, current)

            return cache[Pair(i, current)]!!


        }

        return dfs(0, 0)
    }
}
