class Solution {
    fun partitionLabels(s: String): List<Int> {
        // hash ch: [first position, very last position]
        // if there is only first pos it means that this is only single ch
        // if there are 2 pos, it means we have to substring s from first and last (so character wont appear twice)

        var output = mutableListOf<Int>()

        var hash = HashMap<Char, MutableList<Int>>()

        for (i in 0 until s.count()){
            var ch = s[i]
            if (hash[ch] == null) {
                hash[ch] = mutableListOf()
            }
            if (hash[ch]!!.count() == 2) {
                hash[ch]!!.removeLast()
            }
            hash[ch]!!.add(i)
        }

        fun dfs(startIndex: Int) {

            if (startIndex >= s.count()) {
                return
            }
            val ch = s[startIndex]
            var arr = hash[ch] ?: listOf()

            if (arr.count() == 1) {
                output.add(1)
                dfs(startIndex + 1)
            } else {
                var lastIndex = arr[1]
                var i = startIndex + 1
                while (i <= lastIndex) {
                    val nextArr = hash[s[i]]
                    if (nextArr != null) {
                        lastIndex = maxOf(lastIndex, nextArr.last())
                    }
                    i++
                }
                output.add(lastIndex - startIndex + 1)
                dfs(lastIndex + 1)
            }

        }

        dfs(0)

        return output
    }
}
