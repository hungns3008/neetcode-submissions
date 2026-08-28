class Solution {
    func isPalindrome(_ s: String) -> Bool {
        let newS = Array(s.lowercased())
        var left = 0
        var right = newS.count - 1
        while (left < right) {
            let chLeft = newS[left]
            if !chLeft.isLetter && !chLeft.isNumber {
                left += 1
                continue
            }
            let chRight = newS[right]
            if !chRight.isLetter && !chRight.isNumber {
                right -= 1
                continue
            }
            if (chLeft != chRight) {
                return false
            }
            left += 1
            right -= 1
        }
        return true
    }
}
