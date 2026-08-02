class Solution {
    fun isMatch(s: String, p: String): Boolean {

        var cache = HashMap<Pair<Int, Int>, Boolean>()

        fun dfs(i: Int, j: Int): Boolean {

            if (j == p.count()) {
                return i == s.count()
            }

            val match = i < s.count() && (s[i] == p[j] || p[j] == '.')

            if (j + 1 < p.count() && p[j + 1] == '*') {

                cache[Pair(i, j)] = dfs(i, j + 2) || (match && dfs(i + 1, j))

                return cache[Pair(i, j)]!!

            } 

            cache[Pair(i, j)] = match && dfs(i + 1, j + 1)

            return cache[Pair(i, j)]!!

        }

        return dfs(0, 0)

    }
}