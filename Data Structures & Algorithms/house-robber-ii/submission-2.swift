class Solution {
    func rob(_ nums: [Int]) -> Int {

        if nums.count == 1 {
            return nums[0]
        }

        var cache = [String: Int]() 

        func dfs(_ i: Int, _ robFirstHouse: Bool) -> Int {

            if robFirstHouse {
                if i >= nums.count - 1 {
                    return 0
                }
            } else {
                if i >= nums.count {
                    return 0
                }
            }

            if cache["\(i)-\(robFirstHouse)"] != nil {
                return cache["\(i)-\(robFirstHouse)"]!
            }

            cache["\(i)-\(robFirstHouse)"] = max(nums[i] + dfs(i + 2, robFirstHouse), dfs(i + 1, robFirstHouse))

            return cache["\(i)-\(robFirstHouse)"]!

        }

        return max(dfs(0, true), dfs(1, false))

    }
}
