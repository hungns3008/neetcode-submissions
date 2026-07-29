class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var hash = HashMap<Char, Int>()
        for (s in s1) {
            hash[s] = (hash[s] ?: 0) + 1
        }
        var counter = hash.count()
        var left = 0
        var right = 0
        while (right < s2.count()) {
            var ch = s2[right]
            if (hash[ch] != null) {
                hash[ch] = hash[ch]!! - 1
                if (hash[ch]!! == 0) {
                    counter -= 1
                }
                while (counter == 0) {
                    if (right - left + 1 == s1.count()) {
                        return true
                    }
                    var lChar = s2[left]
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
        return false
    }
}
