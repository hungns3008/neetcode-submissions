class Solution {
    fun jump(nums: IntArray): Int {

        var cache = HashMap<Int, Pair<Int, Boolean>>()

        fun dfs(i: Int): Pair<Int, Boolean> {
            if (i >= nums.count() - 1) {
                return Pair(0, true)
            }
            if (cache[i] != null) {
                return cache[i]!!
            }
            var min = Int.MAX_VALUE
            var reachable = false
            for (j in i + 1 .. i + nums[i]) {
                val jumpToJ = dfs(j)
                if (jumpToJ.second && jumpToJ.first != Int.MAX_VALUE) {
                    min = minOf(min, 1 + jumpToJ.first)
                    reachable = true
                }

            }

            cache[i] = Pair(min, reachable)

            return cache[i]!!

        }

        val result = dfs(0)

        if (result.second) {
            return result.first
        }

        return -1

    }
}