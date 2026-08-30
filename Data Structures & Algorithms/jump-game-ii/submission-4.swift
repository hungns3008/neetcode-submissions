class Solution {
    func jump(_ nums: [Int]) -> Int {

        var cache = [Int: (Int, Bool)]()

        func dfs(_ i: Int) -> (Int, Bool) {

            if i >= nums.count - 1 {
                return (0, true)
            }
            if cache[i] != nil {
                return cache[i]! 
            }
            var minStep = Int.max
            var reachable = false
            let upperLimit = min(i + nums[i], nums.count - 1)
            if i + 1 <= upperLimit {
                for j in i + 1 ... upperLimit {
                    let jumpToJ = dfs(j)
                    if jumpToJ.1 {
                        minStep = min(minStep, 1 + jumpToJ.0)
                        reachable = true
                    }
                }
            }
            cache[i] = (minStep, reachable)
            return cache[i]!
        }

        let (step, canJump) = dfs(0)

        if canJump {
            return step
        }
        return -1

    }
}