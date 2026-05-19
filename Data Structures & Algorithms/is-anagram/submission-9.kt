class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        if (s.count() != t.count()) {
            return false
        }

        var hash = HashMap<Char, Int>()
        for (ch in s) {
            hash[ch] = (hash[ch] ?: 0) + 1
        }
        for (ch in t) {
            if (hash[ch] != null) {
                hash[ch] = (hash[ch] ?: 0) - 1
                if (hash[ch]!! == 0) {
                    hash.remove(ch)
                }
            } else {
                return false
            }
        }
        return hash.count() == 0
    }
}
