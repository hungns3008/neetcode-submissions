class Solution {
    fun numDistinct(s: String, t: String): Int {

        var cache = HashMap<Pair<Int, Int>, Int>()
        
        fun dfs(i: Int, j: Int): Int {

            if (j == t.count()) {
                return 1
            }
            if (i == s.count()) {
                return 0
            }
            if (cache[Pair(i, j)] != null) {
                return cache[Pair(i, j)]!!
            }
            if (s[i] == t[j]) {
                cache[Pair(i, j)] = dfs(i + 1, j + 1) + dfs(i + 1, j)
            } else {
                cache[Pair(i, j)] = dfs(i + 1, j)
            }
            return cache[Pair(i, j)]!!
        }

        return dfs(0, 0)

    }
}
