class Solution {
    fun uniquePaths(m: Int, n: Int): Int {

        var prev = Array(n) { 1 }
        for (r in m - 2 downTo 0) {
            var current = Array(n) { 0 }
            current[current.lastIndex] = 1
            for (c in n - 2 downTo 0) {
                current[c] = current[c + 1] + prev[c]
            }
            prev = current
        }

        return prev[0]

    }
}
