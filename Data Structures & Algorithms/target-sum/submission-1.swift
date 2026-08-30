class Solution {
    func findTargetSumWays(_ nums: [Int], _ target: Int) -> Int {

        var cache = [String: Int]()

        func dfs(_ i: Int, _ sum: Int) -> Int {
            if i == nums.count {
                if sum == target {
                    return 1
                }
                return 0
            }
            if cache["\(i)-\(sum)"] != nil {
                return cache["\(i)-\(sum)"]!
            }
            cache["\(i)-\(sum)"] = dfs(i + 1, sum + nums[i]) + dfs(i + 1, sum - nums[i])
            return cache["\(i)-\(sum)"]!
        }

        return dfs(0, 0)

    }
}
