class Solution {
    func canPartition(_ nums: [Int]) -> Bool {
        var total = 0
        for num in nums {
            total += num
        }
        if total % 2 != 0 {
            return false
        }
        let half = total / 2

        var cache = [String: Bool]()

        func dfs(_ i: Int, _ current: Int) -> Bool {

            if current == half {
                return true
            }

            if i >= nums.count {
                return false
            }

            if cache["\(i)-\(current)"] != nil {
                return cache["\(i)-\(current)"]!
            }

            cache["\(i)-\(current)"] = dfs(i + 1, nums[i] + current) || dfs(i + 1, current)

            return cache["\(i)-\(current)"]!


        }

        return dfs(0, 0)
    }
}
