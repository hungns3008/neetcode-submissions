class Solution {
    func minCostClimbingStairs(_ cost: [Int]) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ current: Int) -> Int {
            if i >= cost.count {
                return current
            }
            if cache["\(i)-\(current)"] != nil {
                return cache["\(i)-\(current)"]!
            }
            cache["\(i)-\(current)"] = min(dfs(i + 1, current + cost[i]), dfs(i + 2, current + cost[i]))
            return cache["\(i)-\(current)"]!
        }

        return min(dfs(0, 0), dfs(1, 0))

    }
}
