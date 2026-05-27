class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var output = 0
        var hash = HashMap<Char, Int>()
        while (right < s.count()) {
            var ch = s[right]
            if (hash[ch] != null) {
                val index = hash[ch]!!
                if (index >= left) {
                    left = index + 1
                }
            }
            output = maxOf(output, right - left + 1)
            hash[ch] = right
            right += 1
        }
        return output
    }
}
