class Solution {
    fun foreignDictionary(words: Array<String>): String {
        var adj = HashMap<Char, HashSet<Char>>()
        for (w in words) {
            for (c in w) {
                if (adj[c] == null) {
                    adj[c] = HashSet<Char>()
                }
            }
        }
        for (i in 0 until words.count() - 1) {
            var w1 = words[i]
            var w2 = words[i + 1]
            val minLen = minOf(w1.count(), w2.count())
            if (w1.count() > w2.count() && w1.substring(0, minLen) == w2.substring(0, minLen)) {
                return ""
            }
            for (j in 0 until minLen) {
                if (w1[j] != w2[j]) {
                    adj[w1[j]]!!.add(w2[j])
                    break
                }
            }
        }

        var visited = mutableSetOf<Char>()
        var path = mutableSetOf<Char>()
        val res = mutableListOf<Char>()

        fun dfs(char: Char): Boolean {
            if (path.contains(char)) {
                return false
            }
            if (visited.contains(char)) {
                return true
            }
            path.add(char)
            for (neighChar in adj[char] ?: emptySet()) {
                if (!dfs(neighChar)) {
                    return false
                }
            }
            path.remove(char)
            visited.add(char)
            res.add(char)
            return true
        }

        for (char in adj.keys) {
            if (!dfs(char)) {
                return ""
            }
        }
        return res.reversed().joinToString("")
    }
}
