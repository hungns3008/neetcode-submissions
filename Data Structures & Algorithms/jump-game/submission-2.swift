class Solution {
    func canJump(_ nums: [Int]) -> Bool {

        var cache = [Int: Bool]()

        func dfs(_ i: Int) -> Bool {
            if i >= nums.count - 1 {
                return true
            }
            if cache[i] != nil {
                return cache[i]!
            }
            let step = nums[i]
            if step > 0 {
                for j in i + 1 ... i + step {
                    if dfs(j) {
                        cache[i] = true
                        return true
                    }
                }
            }
            cache[i] = false
            return false
        }

        return dfs(0)

    }
}
