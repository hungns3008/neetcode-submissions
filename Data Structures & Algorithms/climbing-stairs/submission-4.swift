class Solution {

    var cache = [Int: Int]()

    func climbStairs(_ n: Int) -> Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        if cache[n] != nil {
            return cache[n]!
        }
        cache[n] = climbStairs(n - 1) + climbStairs(n - 2)
        return cache[n]!
    }
}
