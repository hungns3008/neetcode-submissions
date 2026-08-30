class Solution {
    func maxCoins(_ nums: [Int]) -> Int {
        let n = nums.count
        let val = [1] + nums + [1]
        var memo = Array(repeating: Array(repeating: -1, count: n + 2), count: n + 2)

        func dfs(_ left: Int, _ right: Int) -> Int {
            if left + 1 == right {
                return 0
            }
            if memo[left][right] != -1 {
                return memo[left][right]
            }
            var coin = 0

            for i in (left + 1) ..< right {
                let current = val[left] * val[i] * val[right]
                coin = max(coin, current + dfs(left, i) + dfs(i, right))
            }
            
            memo[left][right] = coin
            return coin
        }

        return dfs(0, n + 1)
    }
}