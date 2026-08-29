class Solution {
    func combinationSum(_ nums: [Int], _ target: Int) -> [[Int]] {

        var output = [[Int]]()
        var temp = [Int]()

        func dfs(_ i: Int, _ current: Int) {
            if current == target {
                output.append(temp)
                return
            }
            if i == nums.count || current > target {
                return
            }
            // select at i
            temp.append(nums[i])
            dfs(i, current + nums[i])

            temp.removeLast()
            dfs(i + 1, current)
        }

        dfs(0, 0)

        return output

    }
}
