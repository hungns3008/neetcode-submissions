class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        var wordSet = mutableSetOf<String>()
        var cache = HashMap<Int, Boolean>()

        for (word in wordDict) {
            wordSet.add(word)
        }

        fun dfs(i: Int): Boolean {
            if (i >= s.count()) {
                return true
            }

            if (cache[i] != null) {
                return cache[i]!!
            }

            for (j in i + 1 .. s.count()) {
                var substring = s.substring(i, j)
                if (wordSet.contains(substring)) {
                    if (dfs(j)) {
                        cache[i] = true
                        return true
                    }
                }
            }

            cache[i] = false
            return false

        }

        return dfs(0)

    }
}
