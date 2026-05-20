class Solution {
    fun uniquePaths(m: Int, n: Int): Int {

        var cache = HashMap<String, Int>()

        fun dfs(i: Int, j: Int): Int {
            if (i >= m) {
                return 0
            }
            if (j >= n) {
                return 0
            }
            if (cache["${i}-${j}"] != null) {
                return cache["${i}-${j}"]!!
            }
            if (i == m - 1 && j == n - 1) {
                return 1
            }
            cache["${i}-${j}"] = dfs(i + 1, j) + dfs(i, j + 1)
            return cache["${i}-${j}"]!!
        }

        return dfs(0, 0)

    }
}
