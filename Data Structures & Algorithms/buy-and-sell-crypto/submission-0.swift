class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var minSoFar = prices[0]
        var profit = 0
        for i in 1 ..< prices.count {
            profit = max(profit, prices[i] - minSoFar)
            minSoFar = min(minSoFar, prices[i])
        }
        return profit
    }
}
