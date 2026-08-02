class Solution {
    fun canJump(nums: IntArray): Boolean {

        var cache = HashMap<Int, Boolean>()

        fun dfs(i: Int): Boolean {
            if (i >= nums.count() - 1) {
                return true
            }
            if (cache[i] != null) {
                return cache[i]!!
            }
            for (j in i + 1 .. i + nums[i]) {
                if (dfs(j)) {
                    cache[i] = true
                    return cache[i]!!
                }
            }
            cache[i] = false
            return cache[i]!!
        }

        return dfs(0)

    }
}
