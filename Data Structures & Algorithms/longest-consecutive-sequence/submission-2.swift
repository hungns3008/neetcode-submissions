class Solution {
    func longestConsecutive(_ nums: [Int]) -> Int {
        if nums.isEmpty { return 0 }
        var res = 0
        let arr = nums.sorted()
        var i = 0
        var current = arr[0]
        var length = 0
        while i < arr.count {
            if current != arr[i] {
                length = 0
                current = arr[i]
            }
            while i < arr.count && current == arr[i] {
                i += 1
            }
            length += 1
            current += 1
            res = max(res, length)
        }
        return res
    }
}
