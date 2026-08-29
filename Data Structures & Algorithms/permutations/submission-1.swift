class Solution {
    func permute(_ nums: [Int]) -> [[Int]] {

        func dfs(_ i: Int) -> [[Int]] {

            if i == nums.count {
                return [[]]
            }

            let prev = dfs(i + 1)
            var current = [[Int]]()
            for arrItem in prev {
                for j in 0 ..< arrItem.count + 1 {
                    var arr = arrItem
                    arr.insert(nums[i], at: j)
                    current.append(arr)
                }
            }

            return current
        }

        return dfs(0)

    }
}
