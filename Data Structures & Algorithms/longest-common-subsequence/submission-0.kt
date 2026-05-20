class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        var cache = HashMap<String, Int>()

        fun dfs(i: Int, j: Int): Int {

            if (i >= text1.count() || j >= text2.count()) {
                return 0
            }

            if (cache["${i}-${j}"] != null) {
                return cache["${i}-${j}"]!!
            }

            if (text1[i] == text2[j]) {
                cache["${i}-${j}"] = 1 + dfs(i + 1, j + 1)
                return cache["${i}-${j}"]!!
            }

            cache["${i}-${j}"] = maxOf(dfs(i, j + 1), dfs(i + 1, j))
            return cache["${i}-${j}"]!!

        }

        return dfs(0, 0)

    }
}
