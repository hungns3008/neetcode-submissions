class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {

        var cache = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, current: Int): Int {

            if (i >= nums.count()) {
                return if (current == target) 1 else 0
            }

            if (cache[Pair(i, current)] != null) {
                return cache[Pair(i, current)]!!
            }

            cache[Pair(i, current)] = dfs(i + 1, current + nums[i]) + dfs(i + 1, current - nums[i])

            return cache[Pair(i, current)]!!
        }

        return dfs(0, 0)

    }
}
