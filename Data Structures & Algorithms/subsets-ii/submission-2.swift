class Solution {
    func subsetsWithDup(_ nums: [Int]) -> [[Int]] {
        var sorted = nums.sorted()
        var output = [[Int]]()
        var temp = [Int]()

        func dfs(_ i: Int) {
            if i == sorted.count {
                output.append(temp)
                return
            }
            // select i
            temp.append(sorted[i])
            dfs(i + 1)

            temp.removeLast()
            var j = i + 1
            while j < sorted.count && sorted[j] == sorted[j - 1] {
                j += 1
            }
            dfs(j)
        }

        dfs(0)

        return output
    }
}
