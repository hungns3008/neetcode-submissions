class Solution {
    func subarraySum(_ nums: [Int], _ k: Int) -> Int {
        var prefix = [Int: Int]()
        prefix[0] = 1
        var current = 0
        var res = 0
        for num in nums {
            current += num
            if prefix[current - k] != nil {
                res += prefix[current - k] ?? 0
            }
            prefix[current] = (prefix[current] ?? 0) + 1
        }
        return res
    }
}
