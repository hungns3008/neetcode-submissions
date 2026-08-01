class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        var cache = HashMap<Int, Int>()

        fun dfs(i: Int): Int {
            if (i >= cost.count()) {
                return 0
            }
            if (cache[i] != null) {
                return cache[i]!!
            }
            // pay at index i
            cache[i] = cost[i] + minOf(dfs(i + 1), dfs(i + 2))

            return cache[i]!!

        }

        return minOf(dfs(0), dfs(1))

    }
}
