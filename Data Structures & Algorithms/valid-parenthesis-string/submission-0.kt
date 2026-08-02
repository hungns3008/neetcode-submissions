class Solution {
    fun checkValidString(s: String): Boolean {

        var cache = HashMap<String, Boolean>()

        fun dfs(o: Int, c: Int, i: Int): Boolean {

            if (i >= s.count()) {
                return o == c
            }

            val key = "$o,$c,$i"
            if (cache.containsKey(key)) {
                return cache[key]!!
            }

            if (c <= o) {
                var ch = s[i]
                var isValid = false
                if (ch == '*') {
                    isValid = dfs(o, c, i + 1) || dfs(o + 1, c, i + 1) || dfs(o, c + 1, i + 1)
                } else if (ch == '(') {
                    isValid = dfs(o + 1, c, i + 1)
                } else {
                    isValid = dfs(o, c + 1, i + 1)
                }
                cache[key] = isValid
            } else {
                cache[key] = false
            }
            return cache[key]!!

        }

        return dfs(0, 0, 0)

    }
}