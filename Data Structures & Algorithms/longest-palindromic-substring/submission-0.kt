class Solution {
    fun longestPalindrome(s: String): String {

        var maxLength = -1
        var startIndex = -1

        for (i in 0 until s.count()) {
            var l = i
            var r = i
            while (l >= 0 && r < s.count() && s[l] == s[r]) {
                if (r - l + 1 > maxLength) {
                    maxLength = r - l + 1
                    startIndex = l
                }
                l -= 1
                r += 1
            }
            l = i
            r = i + 1
            while (l >= 0 && r < s.count() && s[l] == s[r]) {
                if (r - l + 1 > maxLength) {
                    maxLength = r - l + 1
                    startIndex = l
                }
                l -= 1
                r += 1
            }
        }

        return s.substring(startIndex, startIndex + maxLength)

    }
}
