class Solution {
    fun change(amount: Int, coins: IntArray): Int {

        var cache = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, current: Int): Int {
            if (current > amount) {
                return 0
            }
            if (current == amount) {
                return 1
            }
            if (i >= coins.count()) {
                if (current == amount) {
                    return 1
                } else {
                    return 0
                }
            }
            if (cache[Pair(i, current)] != null) {
                return cache[Pair(i, current)]!!
            }
            cache[Pair(i, current)] = dfs(i, current + coins[i]) + dfs(i + 1, current)

            // use coin at i
            return cache[Pair(i, current)]!!
        }

        return dfs(0, 0)

    }
}
