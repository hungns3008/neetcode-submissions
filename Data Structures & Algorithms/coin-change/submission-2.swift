class Solution {
    func coinChange(_ coins: [Int], _ amount: Int) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ current: Int) -> Int {

            if i >= coins.count || current >= amount {
                if (current == amount) {
                    return 0
                }
                return Int.max / 2
            }

            if cache["\(i)-\(current)"] != nil {
                return cache["\(i)-\(current)"]!
            }

            var way1 = 1 + dfs(i, current + coins[i])
            var way2 = dfs(i + 1, current)

            cache["\(i)-\(current)"] = min(way1, way2)

            return cache["\(i)-\(current)"]!

        }

        var result = dfs(0, 0)

        return result == Int.max / 2 ? -1 : result

    }
}
