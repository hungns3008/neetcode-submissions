class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {

        fun dfs(i: Int, current: Int): Int {

            if (i >= coins.count() || current >= amount) {
                if (current == amount) {
                    return 0
                }
                return Int.MAX_VALUE / 2
            }

            var way1 = 1 + dfs(i, current + coins[i])
            var way2 = dfs(i + 1, current)

            return minOf(way1, way2)

        }

        var result = dfs(0, 0)

        return if (result == Int.MAX_VALUE / 2) -1 else result

    }
}
