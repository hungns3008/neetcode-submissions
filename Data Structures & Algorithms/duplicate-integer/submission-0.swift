class Solution {
    func hasDuplicate(_ nums: [Int]) -> Bool {
        var map = Set<Int>()
        for num in nums {
            if map.contains(num) {
                return true
            }
            map.insert(num)
        }
        return false
    }
}
