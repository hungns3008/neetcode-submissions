class Solution {
    fun countSubstrings(s: String): Int {

        var counter = 0

        fun count(l: Int, r: Int) {
            var left = l
            var right = r
            while (left >= 0 && right < s.count() && s[left] == s[right]) {
                left -= 1
                right += 1
                counter += 1
            } 
        }

        for (i in 0 until s.count()) {
            count(i, i)
            count(i, i + 1)
        }

        return counter

    }
}
