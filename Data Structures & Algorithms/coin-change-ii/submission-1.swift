class Solution {
    func change(_ amount: Int, _ coins: [Int]) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ current: Int) -> Int {
            if current > amount {
                return 0
            }
            if i == coins.count {
                if current == amount {
                    return 1
                }
                return 0
            }
            if cache["\(i)-\(current)"] != nil {
                return cache["\(i)-\(current)"]!
            }
            cache["\(i)-\(current)"] = dfs(i, current + coins[i]) + dfs(i + 1, current)

            return cache["\(i)-\(current)"]!
        }

        return dfs(0, 0)

    }
}
