class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.count() - 1
        var newS = s.lowercase()
        while (left < right) {
            var lChar = newS[left]
            var rChar = newS[right]
            if ((lChar.toInt() >= 'a'.toInt() && lChar.toInt() <= 'z'.toInt()) || 
                (lChar.toInt() >= '0'.toInt() && lChar.toInt() <= '9'.toInt())) {
            } else {
                left += 1
                continue
            }
            if ((rChar.toInt() >= 'a'.toInt() && rChar.toInt() <= 'z'.toInt()) || 
                (rChar.toInt() >= '0'.toInt() && rChar.toInt() <= '9'.toInt())) {
            } else {
                right -= 1
                continue
            }
            if (lChar == rChar) {
                left += 1
                right -= 1
            } else {
                return false
            }
        }
        return true
    }
}
