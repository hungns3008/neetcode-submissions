class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minSoFar = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.count()) {
            maxProfit = maxOf(maxProfit, maxOf(0, prices[i] - minSoFar))
            minSoFar = minOf(minSoFar, prices[i])
        }
        return maxProfit
    }
}
