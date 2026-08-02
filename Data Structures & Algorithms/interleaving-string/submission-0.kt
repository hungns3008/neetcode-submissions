class Solution {

    var cache = HashMap<Pair<Int, Int>, Boolean>()

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        if (s1.count() + s2.count() != s3.count()) {
            return false
        }

        fun dfs(i: Int, j: Int, k: Int): Boolean {
            if (k >= s3.count()) {
                return true
            }

            if (cache[Pair(i, j)] != null) {
                return cache[Pair(i, j)]!!
            }

            var c = s3[k]
            var aMatches = i < s1.count() && s1[i] == c
            var bMatches = j < s2.count() && s2[j] == c

            if (aMatches && bMatches) {
                cache[Pair(i, j)] = dfs(i + 1, j, k + 1) || dfs(i, j + 1, k + 1)
            } else if (aMatches) {
                cache[Pair(i, j)] = dfs(i + 1, j, k + 1)
            } else if (bMatches) {
                cache[Pair(i, j)] = dfs(i, j + 1, k + 1)
            } else {
                cache[Pair(i, j)] = false
            }
            return cache[Pair(i, j)]!!
        }


        return dfs(0, 0, 0)

    }
}
