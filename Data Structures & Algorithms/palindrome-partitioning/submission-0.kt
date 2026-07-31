class Solution {
    fun partition(s: String): List<List<String>> {

        fun isPali(str: String, left: Int, right: Int): Boolean {
            var l = left
            var r = right
            while (l < r) {
                if (str[l] != str[r]) {
                    return false
                }
                l += 1
                r -= 1
            }
            return true
        }

        var output = mutableListOf<List<String>>()
        var temp = mutableListOf<String>()

        fun dfs(startIndex: Int) {
            if (startIndex >= s.count()) {
                output.add(temp.toList())
                return
            }
            for (endIndex in startIndex until s.count()) {
                var substring = s.substring(startIndex, endIndex + 1)
                if (isPali(s, startIndex, endIndex)) {
                    temp.add(substring)
                    dfs(endIndex + 1)
                    temp.removeLast()
                }
            }
        }

        dfs(0)

        return output

    }
}
