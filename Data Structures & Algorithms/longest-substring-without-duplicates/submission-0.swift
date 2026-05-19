class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        var hash = [Character: Int]()
        var left = 0
        var right = 0
        var arr = Array(s)
        var output = 0

        while right < arr.count {
            if let dupIndex = hash[arr[right]], dupIndex >= left {
                left = dupIndex + 1
            }
            hash[arr[right]] = right
            output = max(output, right - left + 1)
            right += 1
        }
        return output
    }
}
