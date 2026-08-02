class Solution {
    fun maxProfit(prices: IntArray): Int {

        var cache = HashMap<String, Int>()

        fun dfs(i: Int, canBuy: Boolean): Int {

            if (i >= prices.count()) {
                return 0
            }

            if (cache["${i}-${canBuy}"] != null) {
                return cache["${i}-${canBuy}"]!!
            }

            if (canBuy) {
                // buy at i
                var option1 = -prices[i] + dfs(i + 1, !canBuy)
                // skip i
                var option2 = dfs(i + 1, canBuy)
                cache["${i}-${canBuy}"] = maxOf(option1, option2)
            } else {
                // sell at i
                var option1 = prices[i] + dfs(i + 2, true)
                // skip selling at i
                var option2 = dfs(i + 1, false)
                cache["${i}-${canBuy}"] = maxOf(option1, option2)
            }
            return cache["${i}-${canBuy}"]!!
        }

        return dfs(0, true)

    }
}
