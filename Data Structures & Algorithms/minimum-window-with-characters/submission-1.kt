class Solution {
    fun minWindow(s: String, t: String): String {

        var hash = HashMap<Char, Int>()
        for (c in t) {
            hash[c] = (hash[c] ?: 0) + 1
        }
        var counter = hash.count()
        var left = 0
        var right = 0
        var output = ""
        var length = Int.MAX_VALUE
        while (right < s.count()) {
            var ch = s[right]
            if (hash[ch] != null) {
                hash[ch] = hash[ch]!! - 1
                if (hash[ch]!! == 0) {
                    counter -= 1
                }
                while (counter == 0) {
                    if (right - left + 1 < length) {
                        length = right - left + 1
                        output = s.substring(left, right + 1)
                    }
                    var lChar = s[left]
                    if (hash[lChar] != null) {
                        hash[lChar] = hash[lChar]!! + 1
                        if (hash[lChar]!! > 0) {
                            counter += 1
                        }
                    }
                    left += 1
                }
            }
            right += 1
        }
        return output
    }
}
