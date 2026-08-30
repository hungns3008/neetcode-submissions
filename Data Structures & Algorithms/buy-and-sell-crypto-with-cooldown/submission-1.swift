class Solution {
    func maxProfit(_ prices: [Int]) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ hasCoin: Bool, _ profit: Int) -> Int {
            if i >= prices.count {
                return profit
            }

            if cache["\(i)-\(hasCoin)-\(profit)"] != nil {
                return cache["\(i)-\(hasCoin)-\(profit)"]!
            }

            if hasCoin {
                // sell at i
                var p1 = dfs(i + 2, false, profit + prices[i])
                // do not sell at i
                var p2 = dfs(i + 1, hasCoin, profit)
                cache["\(i)-\(hasCoin)-\(profit)"] = max(p1, p2)
            } else {
                // buy at i
                var p1 = dfs(i + 1, true, profit - prices[i])
                // do not buy at i
                var p2 = dfs(i + 1, hasCoin, profit)
                cache["\(i)-\(hasCoin)-\(profit)"] = max(p1, p2)
            }

            return cache["\(i)-\(hasCoin)-\(profit)"]!
            
        }

        return dfs(0, false, 0)

    }
}
