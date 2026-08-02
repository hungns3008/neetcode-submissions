class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        var cache = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if (i >= text1.count() || j >= text2.count()) {
                return 0
            }
            if (cache[Pair(i, j)] != null) {
                return cache[Pair(i, j)]!!
            }
            if (text1[i] == text2[j]) {
                cache[Pair(i, j)] = 1 + dfs(i + 1, j + 1)
            } else {
                cache[Pair(i, j)] = maxOf(dfs(i + 1, j), dfs(i, j + 1))
            }
            return cache[Pair(i, j)]!!
        }

        return dfs(0, 0)

        // var prev = Array(text1.count() + 1) { 0 }

        // for (i in text2.lastIndex - 1 downTo 0) {
        //     var current = Array(text1.count() + 1) { 0 }

        //     for (j in text1.lastIndex downTo 0) {
        //         if (text1[j] == text2[i]) {
        //             current[j] = 1 + prev[j + 1]
        //         } else {
        //             current[j] = maxOf(prev[j], current[j + 1])
        //         }
        //     }
        //     prev = current
        // }

        // return prev[0]

    }
}
