class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {

        var output = mutableListOf<List<Int>>()
        var temp = mutableListOf<Int>()

        fun backtrack(i: Int) {
            if (temp.count() == k) {
                output.add(temp.toList())
                return
            }
            if (i > n) {
                return
            }
            for (j in i .. n) {
                temp.add(j)
                backtrack(j + 1)
                temp.removeLast()
            }
        }

        backtrack(1)

        return output

    }
}
