class Solution {
    func minWindow(_ s: String, _ t: String) -> String {
        var arr = Array(s)
        var left = 0
        var right = 0
        var minLength = Int.max
        var hash = [Character: Int]()
        for ch in t {
            hash[ch] = (hash[ch] ?? 0) + 1
        }
        var counter = hash.count
        var start = 0
        var end = 0
        while right < arr.count {
            if hash[arr[right]] != nil {
                hash[arr[right]] = (hash[arr[right]] ?? 0) - 1
                if hash[arr[right]]! == 0 {
                    counter -= 1
                }
                while counter == 0 {
                    if right - left + 1 < minLength {
                        start = left
                        end = right
                        minLength = right - left + 1
                    }
                    if hash[arr[left]] != nil {
                        hash[arr[left]] = hash[arr[left]]! + 1
                        if hash[arr[left]]! > 0 {
                            counter += 1
                        }
                    }
                    left += 1
                }
            }
            right += 1
        }

        return minLength != Int.max ? String(arr[start...end]) : ""
    }
}
