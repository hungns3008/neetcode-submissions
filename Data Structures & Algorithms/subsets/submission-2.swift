class Solution {
    func subsets(_ nums: [Int]) -> [[Int]] {

        var output = [[Int]]()
        var temp = [Int]()

        func dfs(_ i: Int) {
            if i == nums.count {
                output.append(temp)
                return
            }
            // select i
            temp.append(nums[i])
            dfs(i + 1)
            temp.removeLast()
            dfs(i + 1)
        }

        dfs(0)

        return output

    }
}
