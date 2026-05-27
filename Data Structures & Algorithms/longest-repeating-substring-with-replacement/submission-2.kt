class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left  = 0
        var right = 0
        var hash = HashMap<Char, Int>()
        var mostAppear = 0
        var output = 0
        while (right < s.count()) {

            var ch = s[right]
            hash[ch] = (hash[ch] ?: 0) + 1
            mostAppear = maxOf(mostAppear, hash[ch]!!)

            while (right - left + 1 - mostAppear > k) {
                hash[s[left]] = (hash[s[left]] ?: 0) - 1
                if (hash[s[left]]!! == 0) {
                    hash.remove(s[left])
                }
                left += 1 
            } 
            output = maxOf(output, right - left + 1)
            right += 1
        }
        return output
    }
}
