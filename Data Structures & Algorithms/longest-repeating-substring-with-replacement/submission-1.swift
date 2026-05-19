class Solution {
    func characterReplacement(_ s: String, _ k: Int) -> Int {
        // substring length - most repeated char <= k
        var left = 0
        var right = 0
        var mostCharSoFar = 0
        var output = 0
        var hash = [Character: Int]()
        var arr = Array(s)
        while right < s.count {
            hash[arr[right]] = (hash[arr[right]] ?? 0) + 1 
            mostCharSoFar = max(mostCharSoFar, hash[arr[right]]!)
            if right - left + 1 - mostCharSoFar <= k {
                output = max(output, right - left + 1)
            } else {
                while right - left + 1 - mostCharSoFar > k {
                    hash[arr[left]] = hash[arr[left]]! - 1
                    left += 1
                }
            }
            right += 1
        }
        return output
    }
}
