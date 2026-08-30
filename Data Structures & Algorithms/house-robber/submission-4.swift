class Solution {
    func rob(_ nums: [Int]) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ money: Int) -> Int {
            if i >= nums.count {
                return money
            }
            if cache["\(i)-\(money)"] != nil {
                return cache["\(i)-\(money)"]!
            }
            cache["\(i)-\(money)"] = max(dfs(i + 2, money + nums[i]), dfs(i + 1, money))

            return cache["\(i)-\(money)"]!
        }

        return dfs(0, 0)

    }
}
