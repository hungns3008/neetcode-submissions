class Solution {
    func combinationSum2(_ candidates: [Int], _ target: Int) -> [[Int]] {

        var sorted = candidates.sorted()

        var output = [[Int]]()
        var temp = [Int]()

        func dfs(_ i: Int, _ current: Int) {
            if current == target {
                output.append(temp)
                return
            }
            if i == sorted.count || current > target {
                return
            }
            // select i
            temp.append(sorted[i])
            dfs(i + 1, current + sorted[i])

            temp.removeLast()
            var j = i + 1
            while j < sorted.count && sorted[j] == sorted[j - 1] {
                j += 1
            }
            dfs(j, current)
        }

        dfs(0, 0)

        return output

    }
}
