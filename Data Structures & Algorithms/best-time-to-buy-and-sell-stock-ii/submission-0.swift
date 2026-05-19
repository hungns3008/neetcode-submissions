class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var maxProfit = 0
        
        for i in 0 ..< prices.count - 1 {
            var current = prices[i]
            var next = prices[i + 1]
            if next > current {
                maxProfit += next - current
            }
        } 

        return maxProfit
    }
}
