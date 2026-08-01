class Solution {

    // 101 
    // 10 and 1
    // 10 
    // 23
    
    fun numDecodings(s: String): Int {

        var setNum = mutableSetOf('0', '1', '2', '3', '4', '5', '6')

        var cache = HashMap<Int, Int>()

        fun dfs(i: Int): Int {

            if (i >= s.count()) {
                return 1
            }

            var currentChar = s[i]

            if (currentChar == '0') {
                return 0
            }

            if (cache[i]!= null) {
                return cache[i]!!
            }

            var way = dfs(i + 1)
            
            if (i + 1 < s.count()) {
                var nextChar = s[i + 1]
                if (currentChar == '1' && nextChar in '0' .. '9') {
                    way += dfs(i + 2)
                } else if (currentChar == '2' && nextChar in '0' .. '6') {
                    way += dfs(i + 2)
                }
            } 

            cache[i] = way

            return cache[i]!!

        }

        return dfs(0)

    }
}
